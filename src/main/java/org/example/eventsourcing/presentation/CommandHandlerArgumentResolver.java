package org.example.eventsourcing.presentation;

import javax.servlet.http.HttpServletRequest;

import org.example.eventsourcing.domain.CommandHandler;
import org.example.eventsourcing.domain.CommandHandlerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandHandlerArgumentResolver extends AbstractWebArgumentResolver<CommandHandler> {
    private final CommandHandlerRepository commandHandlerRepository;

    @Autowired
    public CommandHandlerArgumentResolver(CommandHandlerRepository commandHandlerRepository) {
        super(CommandHandler.class);
        this.commandHandlerRepository = commandHandlerRepository;
    }

    @Override
    protected CommandHandler resolveArgument(HttpServletRequest request) {
        return commandHandlerRepository.handlerFor(CommandArgumentResolver.toCommandTypeFrom(request));
    }
}
