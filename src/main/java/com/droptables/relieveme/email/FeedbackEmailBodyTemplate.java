package com.droptables.relieveme.email;

import java.util.Arrays;

public class FeedbackEmailBodyTemplate extends EmailBodyTemplate {

    private static final String TEMPLATE = "User email: %s\n" +
            "Category: %s\n" +
            "Subject: %s\n" +
            "Description: %s\n";

    /**
     * An email template for Feedback/Other emails
     */
    public FeedbackEmailBodyTemplate() {
        super.setTemplate(TEMPLATE);
    }

    /**
     * Adds all fields to super.inputs
     * @param userEmail non-null email of the user
     * @param category non-null category of the email
     * @param subject non-null
     * @param description non-null
     */
    public void fillTemplate(String userEmail, String category, String subject, String description) {
        super.addInput(userEmail);
        super.addInput(category);
        super.addInput(subject);
        super.addInput(description);
    }

    /**
     * Precondition: super.inputs.size() == 4
     * @return the template filled in with super.inputs
     */
    public String getBody() {
        return String.format(super.getTemplate(), super.getInputs().get(0), super.getInputs().get(1),
                super.getInputs().get(2), super.getInputs().get(3));
    }
}
