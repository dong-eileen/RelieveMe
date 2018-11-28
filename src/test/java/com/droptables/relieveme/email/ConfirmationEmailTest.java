package com.droptables.relieveme.email;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConfirmationEmailTest {

    @Test
    public void givenAllFieldsThenSetsFields() {
        FeedbackEmail feedbackEmail = new FeedbackEmail("email", "to", "category", "subject", "desc");
        ConfirmationEmail confirmationEmail = new ConfirmationEmail("from", "to", feedbackEmail);
        assertEquals("RelieveMe has received your email!", confirmationEmail.getSubject());
        assertEquals("RelieveMe has received your email. See below for a receipt of your email:\n\n" +
                "User email: email\n" +
                "Category: category\n" +
                "Subject: subject\n" +
                "Description: desc\n", confirmationEmail.getText());
    }
}