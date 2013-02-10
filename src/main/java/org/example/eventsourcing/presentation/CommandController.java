package org.example.eventsourcing.presentation;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.example.eventsourcing.domain.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/write/{command}")
public class CommandController {
    @Autowired
    private CommandGateway commandGateway;

    @RequestMapping(method = POST)
    public void handle(Command command) {
        commandGateway.sendAndWait(command);
    }
}
