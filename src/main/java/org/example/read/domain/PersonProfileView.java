package org.example.read.domain;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventhandling.replay.ReplayAware;
import org.example.events.PersonRegistered;
import org.example.events.SexChanged;
import org.example.events.ThingBought;
import org.example.eventsourcing.domain.QueryHandler;
import org.example.read.queries.PersonProfileQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonProfileView implements ReplayAware, QueryHandler<PersonProfile, PersonProfileQuery>{
    private PersonProfileRepository repository;

    @Override
    public PersonProfile handle(PersonProfileQuery query) {
        return repository.findOne(query.getPersonId());
    }

    @EventHandler
    private void on(PersonRegistered event) {
        repository.save(new PersonProfile()
                .personId(event.getPersonId())
                .title(event.getTitle())
                .firstName(event.getFirstName())
                .lastName(event.getLastName())
                .birthday(event.getBirthday())
                .gender(event.getGender()));
    }

    @EventHandler
    private void on(SexChanged sexChanged) {
        repository.save(repository.findOne(sexChanged.getPersonId()).gender(sexChanged.getGender()));
    }

    @EventHandler
    private void on(ThingBought thingBought) {
        repository.save(repository.findOne(thingBought.getPersonId()).spent(thingBought.getCost()));
    }

    @Autowired
    public void setPersonProfileRepository(PersonProfileRepository personProfileRepository) {
        this.repository = personProfileRepository;
    }

    @Override
    public void beforeReplay() {
        repository.deleteAll();
    }

    @Override
    public void afterReplay() {
    }
}
