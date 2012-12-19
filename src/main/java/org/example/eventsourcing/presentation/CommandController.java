package org.example.eventsourcing.presentation;

import org.example.eventsourcing.domain.Command;
import org.example.eventsourcing.domain.CommandHandlerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/{command}")
public class CommandController {
    private final CommandHandlerRepository commandHandlerRepository;

    @Autowired
    public CommandController(CommandHandlerRepository commandHandlerRepository) {
        this.commandHandlerRepository = commandHandlerRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void changeSex(Command command) {
        commandHandlerRepository.handlerFor((Class<Command>) command.getClass()).handle(command);
    }
}
