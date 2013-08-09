package org.example.write.domain;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.example.events.TextFieldConfigured;
import org.example.write.commands.ConfigureTextField;

public class TextField extends AbstractAnnotatedAggregateRoot<String> {
    @AggregateIdentifier
    private String guid;

    private TextField() {
    }

    @EventHandler
    private void on(TextFieldConfigured event) {
        this.guid = event.getGuid();
    }

    @CommandHandler
    public TextField(ConfigureTextField command) {
        apply(new TextFieldConfigured(command.getGuid(), command.getName(), command.getLabel(), command.getHintText(),
                command.getMinLength(), command.getMaxLength()));
    }
}
