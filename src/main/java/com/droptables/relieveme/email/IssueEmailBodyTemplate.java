package com.droptables.relieveme.email;

public class IssueEmailBodyTemplate extends EmailBodyTemplate {

    private static final String TEMPLATE = "User email: %s\n" +
            "Category: %s\n" +
            "Bathroom ID: %s\n" +
            "Issue: %s\n" +
            "Description: %s\n";

    /**
     * An email template for Report a Maintenance Issue/ emails
     */
    public IssueEmailBodyTemplate() {
        super.setTemplate(TEMPLATE);
    }

    /**
     * Adds all fields to super.inputs
     * @param userEmail non-null email of the user
     * @param category non-null category of the email
     * @param bathroomId non-null id of the affected bathroom
     * @param subject non-null
     * @param description non-null
     */
    public void fillTemplate(String userEmail, String category, String bathroomId,  String subject,
                             String description) {
        super.addInput(userEmail);
        super.addInput(category);
        super.addInput(bathroomId);
        super.addInput(subject);
        super.addInput(description);
    }

    /**
     * Precondition: super.inputs.size() == 5, super.inputs has only String objects
     * @return the template filled in with super.inputs
     */
    public String getBody() {
        return String.format(super.getTemplate(), super.getInputs().get(0), super.getInputs().get(1),
                super.getInputs().get(2), super.getInputs().get(3), super.getInputs().get(4));
    }
}
