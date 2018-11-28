package com.droptables.relieveme.email;

public class IssueEmail extends Email {

    /**
     * Email for maintenance issue/report inaccurate data emails
     * @param from non-null sender
     * @param to non-null recipient
     * @param category non-null type of email
     * @param bathroomId non-null id of the affected bathroom
     * @param subject non-null summary of the problem
     * @param body non-null description of the problem
     */
    public IssueEmail(String from, String to, String category, Integer bathroomId, String subject, String body) {
        super.setFrom(from);
        super.setTo(to);
        super.setSubject(createSubject(category, bathroomId, subject));
        IssueEmailBodyTemplate issueEmailBodyTemplate = new IssueEmailBodyTemplate();
        issueEmailBodyTemplate.fillTemplate(super.getFrom(), category, bathroomId.toString(), subject, body);
        super.setText(issueEmailBodyTemplate);
    }

    /**
     * Create the subject of the email
     * @param category non-null category of the email
     * @param bathroomId non-null id of the afflicted bathroom
     * @param subject non-null subject of the email
     * @return "[category] subject"
     */
    private String createSubject(String category, Integer bathroomId, String subject) {
        return String.format("[Bathroom %d] [%s] %s", bathroomId, category, subject);
    }
}
