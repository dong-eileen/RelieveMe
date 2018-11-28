package com.droptables.relieveme.email;

import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

public class IssueEmailTest {
    @Test
    public void givenAllFieldsThenSetsFields() {
        IssueEmail feedbackEmail = new IssueEmail("f", "t", "i", 129, "bathroom has reptiles", "REPTILES");
        assertEquals("[Bathroom 129] [i] bathroom has reptiles", feedbackEmail.getSubject());
        assertEquals("f", feedbackEmail.getFrom());
        assertEquals("t", Objects.requireNonNull(feedbackEmail.getTo())[0]);
        assertEquals("User email: f\n" +
                "Category: i\n" +
                "Bathroom ID: 129\n" +
                "Issue: bathroom has reptiles\n" +
                "Description: REPTILES\n", feedbackEmail.getText());
    }
}