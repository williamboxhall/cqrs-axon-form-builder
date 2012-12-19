package org.example.write.application;

import org.example.eventsourcing.domain.CommandHandler;
import org.example.eventsourcing.domain.Guid;
import org.example.eventsourcing.domain.GuidRegister;
import org.example.eventsourcing.domain.Repository;
import org.example.write.domain.Gender;
import org.example.write.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChangeSexCommandHandler implements CommandHandler<ChangeSex> {
    private final Repository<Person> personRepository;
    private final GuidRegister guidRegister;

    @Autowired
    public ChangeSexCommandHandler(Repository<Person> personRepository, GuidRegister guidRegister) {
        this.personRepository = personRepository;
        this.guidRegister = guidRegister;
    }

    @Override
    public void handle(ChangeSex command) {
        Guid guid = guidRegister.verify(command.getGuid());
        Person person = personRepository.getById(guid);
        person.changeSex(Gender.valueOf(command.getGender().toUpperCase()));
        personRepository.save(person);
    }
}
