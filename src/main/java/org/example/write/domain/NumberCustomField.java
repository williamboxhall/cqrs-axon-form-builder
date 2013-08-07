package org.example.write.domain;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.example.events.NumberCustomFieldConfigured;
import org.example.write.commands.ConfigureNumberCustomField;

public class NumberCustomField extends AbstractAnnotatedAggregateRoot<String> {
    @AggregateIdentifier
    private String guid;

    private NumberCustomField() {
    }

    @EventHandler
    private void on(NumberCustomFieldConfigured event) {
        this.guid = event.getGuid();
    }

    @CommandHandler
    public NumberCustomField(ConfigureNumberCustomField command) {
        UnitOfMeasure unitOfMeasure = command.getUnitOfMeasure();
        apply(new NumberCustomFieldConfigured(command.getGuid(), command.getContext(),
                command.getName(), command.getLocale(), command.getLabel(), command.getHintText(),
                unitOfMeasure.getQuantity(), unitOfMeasure.getName(), unitOfMeasure.getSymbol()));
    }
}
