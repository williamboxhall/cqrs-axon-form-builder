package org.example.write.presentation;

import org.example.eventsourcing.CommandHandler;
import org.example.write.application.ChangeSex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/persons")
public class SexChangeController {
    private final CommandHandler<ChangeSex> commandHandler;

    @Autowired
    public SexChangeController(@Qualifier("changeSexCommandHandler") CommandHandler<ChangeSex> commandHandler) {
        this.commandHandler = commandHandler;
    }

    @RequestMapping(value = "/changesex", method = RequestMethod.PUT)
    @ResponseBody
    public void register(@RequestBody ChangeSex changeSex) {
        commandHandler.handle(changeSex);
    }
}
