package com.droptables.relieveme.email;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class EmailServiceTest {
    private static final String DEVELOPER_EMAIL = "relievemedeveloperemail@gmail.com";
    private static final String CONFIRMATION_EMAIL_SUBJECT = "RelieveMe has received your email!";

    @Mock
    private JavaMailSender javaMailSender;

    @InjectMocks
    private EmailService emailService;

    @Before
    public void setUp() throws Exception {
        ReflectionTestUtils.setField(emailService, "DEVELOPER_EMAIL", "relievemedeveloperemail@gmail.com");
    }

    @Test
    public void whenFeedbackEmailRequestedThenSendConfirmationToUser() {
        emailService.sendFeedbackEmail("userEmail", "category", "subject", "body");
        thenEmailIsConfirmationEmail(whenEmailRequested().get(1), "userEmail");
    }

    @Test
    public void whenFeedbackEmailRequestedThenSendFeedbackToDevelopers() {
        emailService.sendFeedbackEmail("userEmail", "category", "subject", "This application is amazing.");
        assertThat(whenEmailRequested().get(0).getTo()[0], is(DEVELOPER_EMAIL));
        assertTrue(whenEmailRequested().get(0).getText().contains("This application is amazing."));
    }

    @Test
    public void whenIssueEmailRequestedThenSendConfirmationToUser() {
        emailService.sendIssueEmail("newUserEmail", "cat", 2, "subject", "body");
        thenEmailIsConfirmationEmail(whenEmailRequested().get(1), "newUserEmail");
    }


    @Test
    public void whenIssueEmailRequestedThenSendIssueToDevelopers() {
        emailService.sendIssueEmail("userEmail", "category", 2, "subject", "There are llamas in the fridge.");
        assertThat(whenEmailRequested().get(0).getTo()[0], is(DEVELOPER_EMAIL));
        assertTrue(whenEmailRequested().get(0).getText().contains("There are llamas in the fridge."));
    }

    private List<SimpleMailMessage> whenEmailRequested() {
        ArgumentCaptor<SimpleMailMessage> mailCaptor = ArgumentCaptor.forClass(SimpleMailMessage.class);
        verify(javaMailSender, times(2)).send(mailCaptor.capture());
        return mailCaptor.getAllValues();
    }

    private void thenEmailIsConfirmationEmail(SimpleMailMessage message, String recipient) {
        assertThat(message.getTo()[0], is(recipient));
        assertThat(message.getSubject(), is(CONFIRMATION_EMAIL_SUBJECT));
    }
}