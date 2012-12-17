package org.example.write.presentation;

import org.example.write.application.RegisterPerson;
import org.example.eventsourcing.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/persons")
public class RegisterPersonController {
    private final CommandHandler<RegisterPerson> commandHandler;

    @Autowired
    public RegisterPersonController(CommandHandler<RegisterPerson> commandHandler) {
        this.commandHandler = commandHandler;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void register(@RequestBody RegisterPerson registerPerson) {
        commandHandler.handle(registerPerson);
    }
}
