package org.example.write.presentation;

import org.example.eventsourcing.domain.CommandHandler;
import org.example.write.application.RegisterPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/registerperson")
public class RegisterPersonController {
    private final CommandHandler<RegisterPerson> commandHandler;

    @Autowired
    public RegisterPersonController(@Qualifier("registerPersonCommandHandler") CommandHandler<RegisterPerson> commandHandler) {
        this.commandHandler = commandHandler;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void register(@RequestBody RegisterPerson registerPerson) {
        commandHandler.handle(registerPerson);
    }
}
