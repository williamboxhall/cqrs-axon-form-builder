package org.example.write.application;

import org.example.eventsourcing.domain.CommandHandler;
import org.example.eventsourcing.domain.Guid;
import org.example.eventsourcing.domain.Repository;
import org.example.write.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChangeSexCommandHandler implements CommandHandler<ChangeSex> {
    private final Repository<Person> personRepository;

    @Autowired
    public ChangeSexCommandHandler(Repository<Person> personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void handle(ChangeSex command) {
        Guid guid = new Guid(command.getGuid());
        Person person = personRepository.getById(guid);
        person.changeSex(command.getGender());
        personRepository.save(person);
    }
}
