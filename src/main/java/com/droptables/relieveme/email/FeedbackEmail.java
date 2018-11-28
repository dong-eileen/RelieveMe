package com.droptables.relieveme.email;

import org.springframework.mail.SimpleMailMessage;

import java.util.Objects;

public class FeedbackEmail extends Email {

    /**
     * Email for Feedback/Other categories
     * @param from non-null email of the sender
     * @param to non-null email of the recipient
     * @param category non-null category of the email
     * @param subject non-null subject of the email
     * @param body non-null body of the email
     */
    public FeedbackEmail(String from, String to, String category, String subject, String body) {
        super.setFrom(from);
        super.setTo(to);
        super.setSubject(createSubject(category, subject));
        FeedbackEmailBodyTemplate feedbackEmailBodyTemplate = new FeedbackEmailBodyTemplate();
        feedbackEmailBodyTemplate.fillTemplate(super.getFrom(), category, subject, body);
        super.setText(feedbackEmailBodyTemplate);
    }

    /**
     * Create the subject of the email
     * @param category non-null category of the email
     * @param subject non-null subject of the email
     * @return "[category] subject"
     */
    private String createSubject(String category, String subject) {
        return String.format("[%s] %s", category, subject);
    }
}
