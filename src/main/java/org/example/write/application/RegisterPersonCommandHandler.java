package org.example.write.application;

import org.example.eventsourcing.CommandHandler;
import org.example.eventsourcing.Guid;
import org.example.eventsourcing.GuidRegistrar;
import org.example.eventsourcing.Repository;
import org.example.write.domain.Birthday;
import org.example.write.domain.Gender;
import org.example.write.domain.Person;
import org.example.write.domain.PersonalInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterPersonCommandHandler implements CommandHandler<RegisterPerson> {
    private final Repository<Person> personRepository;
    private final GuidRegistrar guidRegistrar;

    @Autowired
    public RegisterPersonCommandHandler(Repository<Person> personRepository, GuidRegistrar guidRegistrar) {
        this.personRepository = personRepository;
        this.guidRegistrar = guidRegistrar;
    }

    @Override
    public void handle(RegisterPerson command) {
        personRepository.save(Person.register(guidFrom(command), personalInformationFrom(command)));
    }

    private Guid guidFrom(RegisterPerson command) {
        return guidRegistrar.register(command.getGuid());
    }

    private PersonalInformation personalInformationFrom(RegisterPerson command) {
        return new PersonalInformation(title(command), firstName(command), lastName(command), birthday(command), gender(command));
    }

    private String title(RegisterPerson command) {
        return command.getTitle();
    }

    private String firstName(RegisterPerson command) {
        return command.getFirstName();
    }

    private String lastName(RegisterPerson command) {
        return command.getLastName();
    }

    private Birthday birthday(RegisterPerson command) {
        return Birthday.valueOf(command.getBirthday());
    }

    private Gender gender(RegisterPerson command) {
        return Gender.valueOf(command.getGender().toUpperCase());
    }
}
