package com.droptables.relieveme.domain;

public class Issue {
    private String email;
    private String category;
    private Integer bathroomId;
    private String subject;
    private String description;

    /**
     * Default constructor for JSON parsing
     */
    public Issue() {

    }

    /**
     * Required parameters for Issue
     * @param email user email
     * @param category category of Feedback
     * @param bathroomId id of the affected bathroom
     * @param subject user-inputted subject
     * @param description user-inputted feedback details
     */
    public Issue(String email, String category, Integer bathroomId, String subject, String description) {
        setEmail(email);
        setCategory(category);
        setBathroomId(bathroomId);
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

    public Integer getBathroomId() {
        return bathroomId;
    }

    public void setBathroomId(Integer bathroomId) {
        this.bathroomId = bathroomId;
    }
}
