package com.droptables.relieveme.email;

import org.junit.Before;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

public class FeedbackEmailTest {

    @Test
    public void givenAllFieldsThenSetsFields() {
        FeedbackEmail feedbackEmail = new FeedbackEmail("from", "to", "feed", "sub", "bod");
        assertEquals("[feed] sub", feedbackEmail.getSubject());
        assertEquals("from", feedbackEmail.getFrom());
        assertEquals("to", Objects.requireNonNull(feedbackEmail.getTo())[0]);
        assertEquals("User email: from\n" +
                "Category: feed\n" +
                "Subject: sub\n" +
                "Description: bod\n", feedbackEmail.getText());
    }
}