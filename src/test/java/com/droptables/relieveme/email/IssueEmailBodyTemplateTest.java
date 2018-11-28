package com.droptables.relieveme.email;

import org.junit.Test;

import static org.junit.Assert.*;

public class IssueEmailBodyTemplateTest {

    @Test
    public void givenAllInputsReturnsCorrectBody() {
        IssueEmailBodyTemplate issueEmailBodyTemplate = new IssueEmailBodyTemplate();
        issueEmailBodyTemplate.fillTemplate("email", "cat", "1", "sub", "desc");
        assertEquals("User email: email\n" +
                "Category: cat\n" +
                "Bathroom ID: 1\n" +
                "Issue: sub\n" +
                "Description: desc\n", issueEmailBodyTemplate.getBody());
    }
}