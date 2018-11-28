package com.droptables.relieveme.controller;

import com.droptables.relieveme.converter.HttpServletRequestToJsonConverter;
import com.droptables.relieveme.domain.Feedback;
import com.droptables.relieveme.email.EmailService;
import com.github.mkopylec.recaptcha.validation.RecaptchaValidator;
import com.github.mkopylec.recaptcha.validation.ValidationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("${rest-controller-prefix}/feedbackForm")
public class FeedbackFormController {

    private final EmailService emailService;
    private final RecaptchaValidator recaptchaValidator;

    @Autowired
    public FeedbackFormController(EmailService emailService, RecaptchaValidator recaptchaValidator) {
        this.emailService = emailService;
        this.recaptchaValidator = recaptchaValidator;
    }

    /**
     * Receives feedback from the user and sends a feedback email to both the user
     * and the developers. A captcha is used to determine if a request is a spam
     * request.
     *
     * @param request feedback post request
     * @return Http OK if the captcha succeeds. Http BAD REQUEST if the captcha
     *         fails.
     * @throws IOException if the request can't be read
     */
    @PostMapping("/submitFeedback")
    public ResponseEntity submitFeedback(HttpServletRequest request) throws IOException {
        // get remote address
        String ipAddress = request.getRemoteAddr();
        // convert to JSON
        Map<String, Object> reqBody = HttpServletRequestToJsonConverter.convertPostRequestToJson(request);
        ValidationResult captchaResult = recaptchaValidator.validate((String) reqBody.get("captcha"), ipAddress);
        if (captchaResult.isSuccess()) {
            this.submitFeedback(new Feedback((String) reqBody.get("email"), (String) reqBody.get("category"),
                    (String) reqBody.get("subject"), (String) reqBody.get("description")));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /**
     * Take feedback and send an email to the user who submitted the feedback and
     * the developers.
     *
     * @param feedback non-null feedback information
     */
    protected void submitFeedback(Feedback feedback) {
        emailService.sendFeedbackEmail(feedback.getEmail(), feedback.getCategory(), feedback.getSubject(),
                feedback.getDescription());
    }
}
