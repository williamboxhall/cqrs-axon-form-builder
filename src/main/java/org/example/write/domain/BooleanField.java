package org.example.write.domain;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.example.events.BooleanFieldConfigured;
import org.example.write.commands.ConfigureBooleanField;

public class BooleanField extends Field {
    @AggregateIdentifier
    private String name;

    private BooleanField() {
    }

    @EventHandler
    private void on(BooleanFieldConfigured event) {
        this.name = event.getName();
    }

    @CommandHandler
    public BooleanField(ConfigureBooleanField command) {
        apply(new BooleanFieldConfigured(command.getName(), command.getLabel(), command.getHintText()));
    }

    @Override
    boolean isValid(String value) {
        return isBoolean(value);
    }

    private boolean isBoolean(String value) {
        return "true".equals(value) || "false".equals(value);
    }
}
