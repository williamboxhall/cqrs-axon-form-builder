package org.example.eventsourcing.presentation;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.example.eventsourcing.domain.Command;
import org.example.eventsourcing.domain.CommandHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{command}")
public class CommandController {
    @RequestMapping(method = POST)
    public void handle(CommandHandler<Command> commandHandler, Command command) {
        commandHandler.handle(command);
    }
}
