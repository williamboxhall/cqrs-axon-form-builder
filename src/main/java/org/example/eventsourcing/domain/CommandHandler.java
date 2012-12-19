package org.example.eventsourcing.domain;

public interface CommandHandler<T extends Command> {
    void handle(T command);
}
