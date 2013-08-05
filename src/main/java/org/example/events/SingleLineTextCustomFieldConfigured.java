package org.example.events;

public class SingleLineTextCustomFieldConfigured extends CustomFieldConfigured {
    private final int minLength;
    private final int maxLength;

    public SingleLineTextCustomFieldConfigured(String guid, String context, String name, String locale, String label, String hintText, int minLength, int maxLength) {
        super(guid, context, name, locale, label, hintText);
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
