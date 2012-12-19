package org.example.write.presentation;

import org.example.eventsourcing.domain.CommandHandler;
import org.example.write.application.ChangeSex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/changesex")
public class ChangeSexController {
    private final CommandHandler<ChangeSex> commandHandler;

    @Autowired
    public ChangeSexController(@Qualifier("changeSexCommandHandler") CommandHandler<ChangeSex> commandHandler) {
        this.commandHandler = commandHandler;
    }

    @RequestMapping(value = "/changesex", method = RequestMethod.PUT)
    public void changeSex(@RequestBody ChangeSex changeSex) {
        commandHandler.handle(changeSex);
    }
}
