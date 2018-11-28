package com.droptables.relieveme.controller;

import com.droptables.relieveme.domain.Feedback;
import com.droptables.relieveme.email.EmailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mkopylec.recaptcha.validation.RecaptchaValidator;
import com.github.mkopylec.recaptcha.validation.ValidationResult;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FeedbackFormControllerTest {
    @Mock
    private EmailService emailService;
    @Mock
    private RecaptchaValidator recaptchaValidator;
    @Mock
    private ValidationResult validationResult;

    @InjectMocks
    private FeedbackFormController feedbackFormController;

    private MockHttpServletRequest mockHttpServletRequest;

    @Before
    public void setUp() {
        mockHttpServletRequest = new MockHttpServletRequest("POST", null);
        when(recaptchaValidator.validate(anyString(), anyString())).thenReturn(validationResult);
    }

    @Test
    public void givenValidFeedbackThenCallEmailService() throws Exception {
        givenValidFeedbackBody(new Feedback("email", "cat", "sub", "bod"));
        givenSuccessfulCaptcha();
        feedbackFormController.submitFeedback(mockHttpServletRequest);
        verify(emailService).sendFeedbackEmail("email", "cat", "sub", "bod");
    }

    @Test
    public void failedCaptchaReturnsBadRequest() throws Exception {
        givenValidFeedbackBody(new Feedback("email", "cat", "sub", "bod"));
        ResponseEntity responseEntity = feedbackFormController.submitFeedback(mockHttpServletRequest);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    private void givenValidFeedbackBody(Feedback feedback) throws Exception {
        String feedbackJson = new ObjectMapper().writeValueAsString(feedback);
        feedbackJson = feedbackJson.replaceFirst(",", ",\"captcha\":\"\",");
        mockHttpServletRequest.setContent(feedbackJson.getBytes());
    }

    private void givenSuccessfulCaptcha() {
        when(validationResult.isSuccess()).thenReturn(true);
    }
}