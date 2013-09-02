package org.example.events;

public abstract class FieldConfigured {
    private final String name;
    private final String label;
    private final String hintText;

    public FieldConfigured(String name, String label, String hintText) {
        this.name = name;
        this.label = label;
        this.hintText = hintText;
    }

    public String getName() {
        return name;
    }

    public String getLabel() {
        return label;
    }

    public String getHintText() {
        return hintText;
    }
}
