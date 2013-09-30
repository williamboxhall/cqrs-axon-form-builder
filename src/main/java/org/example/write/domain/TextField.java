package org.example.write.domain;

import static com.google.common.base.Strings.nullToEmpty;

import com.google.common.base.Strings;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.example.events.TextFieldConfigured;
import org.example.write.commands.ConfigureTextField;

public class TextField extends Field {
    @AggregateIdentifier
    private String name;
    private int minLength;
    private int maxLength;

    private TextField() {
    }

    @EventHandler
    private void on(TextFieldConfigured event) {
        this.name = event.getName();
        this.minLength = event.getMinLength();
        this.maxLength = event.getMaxLength();
    }

    @CommandHandler
    public TextField(ConfigureTextField command) {
        apply(new TextFieldConfigured(command.getName(), command.getLabel(), command.getHintText(),
                command.getMinLength(), command.getMaxLength()));
    }

    @Override
    boolean isValid(String value) {
        int length = nullToEmpty(value).trim().length();
        return length >= minLength && length <= maxLength;
    }
}
