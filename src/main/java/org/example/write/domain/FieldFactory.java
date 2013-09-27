package org.example.write.domain;

import static org.example.eventsourcing.infrastructure.Reflections.newInstanceOf;

import org.axonframework.domain.DomainEventMessage;
import org.axonframework.eventsourcing.AbstractAggregateFactory;
import org.example.events.BooleanFieldConfigured;
import org.example.events.NumberFieldConfigured;
import org.example.events.TextFieldConfigured;
import org.springframework.stereotype.Component;

@Component
public class FieldFactory extends AbstractAggregateFactory<Field> {
    @Override
    protected Field doCreateAggregate(Object aggregateIdentifier, DomainEventMessage firstEvent) {
        if (BooleanFieldConfigured.class.isAssignableFrom(firstEvent.getPayloadType())) {
            return newInstanceOf(BooleanField.class);
        } else if (NumberFieldConfigured.class.isAssignableFrom(firstEvent.getPayloadType())) {
            return newInstanceOf(NumberField.class);
        } else if (TextFieldConfigured.class.isAssignableFrom(firstEvent.getPayloadType())) {
            return newInstanceOf(TextField.class);
        } else {
            throw new RuntimeException("Unrecognised field creation event " + firstEvent.getPayloadType());
        }
    }

    @Override
    public String getTypeIdentifier() {
        return Field.class.getSimpleName();
    }

    @Override
    public Class<Field> getAggregateType() {
        return Field.class;
    }
}
