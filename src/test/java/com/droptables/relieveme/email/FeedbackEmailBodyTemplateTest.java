package com.droptables.relieveme.email;

import org.junit.Test;

import static org.junit.Assert.*;

public class FeedbackEmailBodyTemplateTest {

    @Test
    public void givenAllInputsReturnsCorrectBody() {
        FeedbackEmailBodyTemplate feedbackEmailBodyTemplate = new FeedbackEmailBodyTemplate();
        feedbackEmailBodyTemplate.fillTemplate("email", "cat", "sub", "desc");
        assertEquals("User email: email\n" +
                "Category: cat\n" +
                "Subject: sub\n" +
                "Description: desc\n", feedbackEmailBodyTemplate.getBody());
    }
}