package com.droptables.relieveme.controller;

import com.droptables.relieveme.converter.HttpServletRequestToJsonConverter;
import com.droptables.relieveme.domain.Issue;
import com.droptables.relieveme.email.EmailService;
import com.droptables.relieveme.service.BathroomService;
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
@RequestMapping("${rest-controller-prefix}/issueForm")
public class IssueFormController {

    private final EmailService emailService;
    private final BathroomService bathroomService;
    private final RecaptchaValidator recaptchaValidator;

    @Autowired
    public IssueFormController(EmailService emailService, BathroomService bathroomService,
            RecaptchaValidator recaptchaValidator) {
        this.emailService = emailService;
        this.bathroomService = bathroomService;
        this.recaptchaValidator = recaptchaValidator;
    }

    /**
     * Receives an issue report from the user and sends an issue email to both the
     * user and the developers. A captcha is used to determine if a request is a
     * spam request.
     *
     * @param request feedback post request
     * @return Http OK if the captcha succeeds. Http BAD REQUEST if the captcha
     *         fails.
     * @throws IOException if the request can't be read
     */
    @PostMapping("/submitIssue")
    public ResponseEntity submitIssue(HttpServletRequest request) throws IOException {
        // get remote address
        String ipAddress = request.getRemoteAddr();
        // convert to JSON
        Map<String, Object> reqBody = HttpServletRequestToJsonConverter.convertPostRequestToJson(request);

        ValidationResult captchaResult = recaptchaValidator.validate((String) reqBody.get("captcha"), ipAddress);
        if (captchaResult.isSuccess()) {
            this.submitIssue(new Issue((String) reqBody.get("email"), (String) reqBody.get("category"),
                    ((Long) reqBody.get("bathroomId")).intValue(), (String) reqBody.get("subject"),
                    (String) reqBody.get("description")));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /**
     * Take an issue report and sends an email to the user who submitted the issue
     * and the developers. Also updates maintenance issue flag on the afflicted
     * bathroom.
     *
     * @param issue non-null issue information
     */
    protected void submitIssue(Issue issue) {
        emailService.sendIssueEmail(issue.getEmail(), issue.getCategory(), issue.getBathroomId(), issue.getSubject(),
                issue.getDescription());
        bathroomService.setOngoingBathroomIssueToTrue(issue.getBathroomId());
    }
}
