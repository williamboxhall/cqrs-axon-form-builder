package org.example.write.domain;

import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;

public abstract class Field extends AbstractAnnotatedAggregateRoot<String> {
    abstract boolean isValid(String value);
}
