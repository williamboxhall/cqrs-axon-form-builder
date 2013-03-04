package org.example.write.commands;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.example.write.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoSomethingCommandHandler {
    @Autowired
    private Repository<Person> personRepository;

    @CommandHandler
    public void handle(DoSomething doSomething) {
        Person person = personRepository.load(doSomething.getPersonId());
        person.doSomething(doSomething.getSomething());
    }
}
