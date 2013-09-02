package org.example.events;

public class TextFieldConfigured extends FieldConfigured {
    private final int minLength;
    private final int maxLength;

    public TextFieldConfigured(String name, String label, String hintText, int minLength, int maxLength) {
        super(name, label, hintText);
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    public int getMinLength() {
        return minLength;
    }

    public int getMaxLength() {
        return maxLength;
    }
}
