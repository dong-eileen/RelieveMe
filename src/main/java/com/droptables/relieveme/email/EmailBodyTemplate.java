package com.droptables.relieveme.email;

import java.util.ArrayList;
import java.util.List;

public abstract class EmailBodyTemplate {
    private List<String> inputs = new ArrayList<>();
    private String template;

    /**
     * Adds user-input to include in the template.
     * @param input is non-null
     */
    public void addInput(String input) {
        inputs.add(input);
    }

    protected List<String> getInputs() {
        return inputs;
    }

    /**
     * Fill in the template with inputted text
     * @return a string with the complete body
     */
    public abstract String getBody();

    protected String getTemplate() {
        return template;
    }

    protected void setTemplate(String template) {
        this.template = template;
    }
}
