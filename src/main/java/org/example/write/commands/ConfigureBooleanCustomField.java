package org.example.write.commands;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import org.example.eventsourcing.domain.Command;
import org.hibernate.validator.constraints.NotBlank;

public class ConfigureBooleanCustomField implements Command {
    @TargetAggregateIdentifier
    @NotBlank
    private String booleanCustomFieldGuid;
    @NotBlank
    private String context;
    @NotBlank
    private String name;
    @NotBlank
    private String locale;
    @NotBlank
    private String label;
    @NotBlank
    private String tooltip;

    public String getBooleanCustomFieldGuid() {
        return booleanCustomFieldGuid;
    }

    public void setBooleanCustomFieldGuid(String booleanCustomFieldGuid) {
        this.booleanCustomFieldGuid = booleanCustomFieldGuid;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTooltip() {
        return tooltip;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }
}
