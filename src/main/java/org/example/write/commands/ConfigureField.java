package org.example.write.commands;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import org.example.eventsourcing.domain.Command;
import org.hibernate.validator.constraints.NotBlank;

public class ConfigureField implements Command {
    @TargetAggregateIdentifier
    @NotBlank
    private String name;
    @NotBlank
    private String label;
    @NotBlank
    private String hintText;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getHintText() {
        return hintText;
    }

    public void setHintText(String hintText) {
        this.hintText = hintText;
    }
}
