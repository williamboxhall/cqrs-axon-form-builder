package org.example.events;

public abstract class CustomFieldConfigured {
    private final String guid;
    private final String context;
    private final String name;
    private final String locale;
    private final String label;
    private final String hintText;

    public CustomFieldConfigured(String guid, String context, String name, String locale, String label, String hintText) {
        this.guid = guid;
        this.context = context;
        this.name = name;
        this.locale = locale;
        this.label = label;
        this.hintText = hintText;
    }

    public String getGuid() {
        return guid;
    }

    public String getContext() {
        return context;
    }

    public String getName() {
        return name;
    }

    public String getLocale() {
        return locale;
    }

    public String getLabel() {
        return label;
    }

    public String getHintText() {
        return hintText;
    }
}
