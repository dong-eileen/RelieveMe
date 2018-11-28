package com.droptables.relieveme.email;

public class ConfirmationEmail extends Email {

    private static final String SUBJECT = "RelieveMe has received your email!";
    private static final String BODY = "RelieveMe has received your email. See below for a receipt of your email:\n\n";

    /**
     * Create a confirmation email.
     * @param from non-null sender
     * @param to non-null receipient
     * @param email non-null email that we want to create a receipt for
     */
    public ConfirmationEmail(String from, String to, Email email) {
        super.setFrom(from);
        super.setTo(to);
        super.setSubject(SUBJECT);
        super.setText(BODY + email.getText());
    }
}
