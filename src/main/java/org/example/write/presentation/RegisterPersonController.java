package org.example.write.presentation;

import org.example.write.command.RegisterPerson;
import org.example.write.infrastructure.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/persons")
public class RegisterPersonController {
    @Autowired
    private CommandHandler<RegisterPerson> commandHandler;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void register(@RequestBody RegisterPerson registerPerson) {
        commandHandler.handle(registerPerson);
    }
}
