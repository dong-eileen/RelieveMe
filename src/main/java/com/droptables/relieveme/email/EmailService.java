package com.droptables.relieveme.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class EmailService {

    @Value("${spring.mail.username}")
    private String DEVELOPER_EMAIL;
    private final JavaMailSender emailSender;

    @Autowired
    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    /**
     * Send feedback email to the user and to the developers
     * 
     * @param userEmail non-null user email
     * @param category  non-null category of the email to append to the subject
     * @param bathroomId non-null bathroom id
     * @param subject   non-null user-inputted subject
     * @param body      non-null user-inputted body
     */
    public void sendIssueEmail(String userEmail, String category, Integer bathroomId, String subject, String body) {
        IssueEmail issueEmail = sendIssueEmailToDevelopers(userEmail, category, bathroomId, subject, body);
        sendConfirmationEmail(userEmail, issueEmail);
    }

    /**
     * Send feedback email to the developers
     * @param userEmail non-null user email
     * @param category non-null category
     * @param bathroomId non-null bathroom id
     * @param subject non-null user-inputted subject line
     * @param body non-null user-inputted description
     * @return the feedback email sent
     */
    private IssueEmail sendIssueEmailToDevelopers(String userEmail, String category, Integer bathroomId,
                                                     String subject, String body) {
        IssueEmail issueEmailToDevelopers = new IssueEmail(userEmail, DEVELOPER_EMAIL, category, bathroomId, subject,body);
        emailSender.send(issueEmailToDevelopers);
        return issueEmailToDevelopers;
    }

    /**
     * Send a confirmation email to the user from email.getTo.
     * 
     * @param toEmail non-null email to send to
     * @param email   non-null email we want to create a receipt for
     */
    private void sendConfirmationEmail(String toEmail, Email email) {
        ConfirmationEmail confirmationEmail = new ConfirmationEmail(DEVELOPER_EMAIL, toEmail, email);
        emailSender.send(confirmationEmail);
    }

    /**
     * Send feedback email to the user and to the developers
     * @param userEmail non-null user email
     * @param category non-null category of the email to append to the subject
     * @param subject non-null user-inputted subject
     * @param body non-null user-inputted body
     */
    public void sendFeedbackEmail(String userEmail, String category, String subject, String body) {
        FeedbackEmail feedbackEmail = sendFeedbackEmailToDevelopers(userEmail, category, subject, body);
        sendConfirmationEmail(userEmail, feedbackEmail);
    }

    /**
     * Send feedback email to the developers
     * 
     * @param userEmail non-null user email
     * @param category  non-null category
     * @param subject   non-null user-inputted subject line
     * @param body      non-null user-inputted description
     * @return the feedback email sent
     */
    private FeedbackEmail sendFeedbackEmailToDevelopers(String userEmail, String category, String subject,
            String body) {
        FeedbackEmail feedbackEmailToDevelopers = new FeedbackEmail(userEmail, DEVELOPER_EMAIL, category, subject,
                body);
        emailSender.send(feedbackEmailToDevelopers);
        return feedbackEmailToDevelopers;
    }
}
