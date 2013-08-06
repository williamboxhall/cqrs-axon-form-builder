package org.example.write.domain;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.example.events.SingleLineTextCustomFieldConfigured;
import org.example.write.commands.ConfigureSingleLineTextCustomField;

public class SingleLineTextCustomField extends AbstractAnnotatedAggregateRoot<String> {
    @AggregateIdentifier
    private String guid;

    private SingleLineTextCustomField() {
    }

    @EventHandler
    private void on(SingleLineTextCustomFieldConfigured event) {
        this.guid = event.getGuid();
    }

    @CommandHandler
    public SingleLineTextCustomField(ConfigureSingleLineTextCustomField command) {
        apply(new SingleLineTextCustomFieldConfigured(command.getGuid(), command.getContext(),
                command.getName(), command.getLocale(), command.getLabel(),
                command.getHintText(), command.getMinLength(), command.getMaxLength()));
    }
}