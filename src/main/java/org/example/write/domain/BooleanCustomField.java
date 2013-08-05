package org.example.write.domain;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.example.events.BooleanCustomFieldConfigured;
import org.example.write.commands.ConfigureBooleanCustomField;

public class BooleanCustomField extends AbstractAnnotatedAggregateRoot<String> {
    @AggregateIdentifier
    private String guid;

    private BooleanCustomField() {
    }

    @EventHandler
    private void on(BooleanCustomFieldConfigured event) {
        this.guid = event.getGuid();
    }

    @CommandHandler
    public BooleanCustomField(ConfigureBooleanCustomField command) {
        apply(new BooleanCustomFieldConfigured(command.getGuid(), command.getContext(),
                command.getName(), command.getLocale(), command.getLabel(), command.getHintText()));
    }
}
