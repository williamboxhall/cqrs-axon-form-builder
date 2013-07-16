package org.example.write.domain;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.example.events.BooleanCustomFieldConfigured;
import org.example.write.commands.ConfigureBooleanCustomField;

public class BooleanCustomField extends AbstractAnnotatedAggregateRoot<String> {
    @AggregateIdentifier
    private String booleanCustomFieldGuid;

    private BooleanCustomField() {
    }

    @EventHandler
    private void on(BooleanCustomFieldConfigured booleanCustomFieldConfigured) {
        this.booleanCustomFieldGuid = booleanCustomFieldConfigured.getBooleanCustomFieldGuid();
    }

    @CommandHandler
    public BooleanCustomField(ConfigureBooleanCustomField configuration) {
        apply(new BooleanCustomFieldConfigured(configuration.getBooleanCustomFieldGuid(), configuration.getContext(),
                configuration.getName(), configuration.getLocale(), configuration.getLabel(), configuration.getTooltip()));
    }
}
