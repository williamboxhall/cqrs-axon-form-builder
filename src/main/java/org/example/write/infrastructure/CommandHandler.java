package org.example.write.infrastructure;

public interface CommandHandler<T> {
    void handle(T command);
}
