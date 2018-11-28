package com.droptables.relieveme.controller;

import com.droptables.relieveme.domain.Issue;
import com.droptables.relieveme.email.EmailService;
import com.droptables.relieveme.service.BathroomService;
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
public class IssueFormControllerTest {
    @Mock
    private EmailService emailService;
    @Mock
    private RecaptchaValidator recaptchaValidator;
    @Mock
    private ValidationResult validationResult;
    @Mock
    private BathroomService bathroomService;

    @InjectMocks
    private IssueFormController issueFormController;

    private MockHttpServletRequest mockHttpServletRequest;

    @Before
    public void setUp() {
        mockHttpServletRequest = new MockHttpServletRequest("POST", null);
        when(recaptchaValidator.validate(anyString(), anyString())).thenReturn(validationResult);
    }

    @Test
    public void givenValidIssueThenCallEmailService() throws Exception {
        givenValidIssueBody(new Issue("email", "cat", 1, "sub", "bod"));
        givenSuccessfulCaptcha();
        issueFormController.submitIssue(mockHttpServletRequest);
        verify(emailService).sendIssueEmail("email", "cat", 1, "sub", "bod");
    }

    @Test
    public void givenValidIssueThenUpdateBathroom() throws Exception {
        givenValidIssueBody(new Issue("email", "cat", 12, "sub", "bod"));
        givenSuccessfulCaptcha();
        issueFormController.submitIssue(mockHttpServletRequest);
        verify(bathroomService).setOngoingBathroomIssueToTrue(12);
    }

    @Test
    public void failedCaptchaReturnsBadRequest() throws Exception {
        givenValidIssueBody(new Issue("email", "cat", 1, "sub", "bod"));
        ResponseEntity responseEntity = issueFormController.submitIssue(mockHttpServletRequest);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    private void givenValidIssueBody(Issue issue) throws Exception {
        String issueJson = new ObjectMapper().writeValueAsString(issue);
        issueJson = issueJson.replaceFirst(",", ",\"captcha\":\"\",");
        mockHttpServletRequest.setContent(issueJson.getBytes());
    }

    private void givenSuccessfulCaptcha() {
        when(validationResult.isSuccess()).thenReturn(true);
    }
}