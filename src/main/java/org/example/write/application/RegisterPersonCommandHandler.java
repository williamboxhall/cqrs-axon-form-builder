package org.example.write.application;

import org.example.eventsourcing.domain.CommandHandler;
import org.example.eventsourcing.domain.Guid;
import org.example.eventsourcing.domain.Repository;
import org.example.write.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterPersonCommandHandler implements CommandHandler<RegisterPerson> {
    private final Repository<Person> personRepository;

    @Autowired
    public RegisterPersonCommandHandler(Repository<Person> personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void handle(RegisterPerson command) {
        personRepository.save(Person.register(new Guid(command.getGuid()), command.getTitle(), command.getFirstName(),
                command.getLastName(), command.getBirthday(), command.getGender()));
    }
}
