package org.example.eventsourcing;

public interface CommandHandler<T> {
    void handle(T command);
}
