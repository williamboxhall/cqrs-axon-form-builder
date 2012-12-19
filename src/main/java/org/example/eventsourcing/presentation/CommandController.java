package org.example.eventsourcing.presentation;

import org.example.eventsourcing.domain.Command;
import org.example.eventsourcing.domain.CommandHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/{command}")
public class CommandController {
    @RequestMapping(method = RequestMethod.POST)
    public void changeSex(CommandHandler<Command> commandHandler, Command command) {
        commandHandler.handle(command);
    }
}
