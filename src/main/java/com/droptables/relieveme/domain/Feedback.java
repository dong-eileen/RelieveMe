package com.droptables.relieveme.domain;

public class Feedback {

    private String email;
    private String category;
    private String subject;
    private String description;

    /**
     * Default constructor for JSON parsing
     */
    public Feedback() {

    }

    /**
     * Required parameters for Feedback
     * @param email user email
     * @param category category of Feedback
     * @param subject user-inputted subject
     * @param description user-inputted feedback details
     */
    public Feedback(String email, String category, String subject, String description) {
        setEmail(email);
        setCategory(category);
        setSubject(subject);
        setDescription(description);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
