package org.example.read.views;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BooleanCustomFieldConigurationDto {
    @Id
    private String booleanCustomFieldGuid;
    private String context;
    private String name;
    private String locale;
    private String label;
    private String tooltip;

    public BooleanCustomFieldConigurationDto booleanCustomFieldGuid(String booleanCustomFieldGuid) {
        this.booleanCustomFieldGuid = booleanCustomFieldGuid;
        return this;
    }

    public BooleanCustomFieldConigurationDto context(String context) {
        this.context = context;
        return this;
    }

    public BooleanCustomFieldConigurationDto name(String name) {
        this.name = name;
        return this;
    }

    public BooleanCustomFieldConigurationDto locale(String locale) {
        this.locale = locale;
        return this;
    }

    public BooleanCustomFieldConigurationDto label(String label) {
        this.label = label;
        return this;
    }

    public BooleanCustomFieldConigurationDto tooltip(String tooltip) {
        this.tooltip = tooltip;
        return this;
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
