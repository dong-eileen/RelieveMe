package com.droptables.relieveme.email;

import org.springframework.mail.SimpleMailMessage;

public class Email extends SimpleMailMessage {

    /**
     * Sets the text of this email to a given template
     * @param template is non-null
     */
    public void setText(EmailBodyTemplate template) {
        super.setText(template.getBody());
    }
}
