package org.example.events;

public class BooleanCustomFieldConfigured {
    private final String booleanCustomFieldGuid;
    private final String context;
    private final String name;
    private final String locale;
    private final String label;
    private final String tooltip;

    public BooleanCustomFieldConfigured(String booleanCustomFieldGuid, String context, String name, String locale, String label, String tooltip) {
        this.booleanCustomFieldGuid = booleanCustomFieldGuid;
        this.context = context;
        this.name = name;
        this.locale = locale;
        this.label = label;
        this.tooltip = tooltip;
    }

    public String getBooleanCustomFieldGuid() {
        return booleanCustomFieldGuid;
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

    public String getTooltip() {
        return tooltip;
    }
}
