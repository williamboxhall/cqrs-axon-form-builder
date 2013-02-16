package org.example.read.projectors;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventhandling.replay.ReplayAware;
import org.example.events.PersonRegistered;
import org.example.events.SexChanged;
import org.example.events.ThingBought;
import org.example.eventsourcing.domain.QueryHandler;
import org.example.read.queries.PersonProfile;
import org.example.read.views.PersonProfileScreen;
import org.example.read.views.PersonProfileView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonProfileProjector implements ReplayAware, QueryHandler<PersonProfileView, PersonProfile>{
    private PersonProfileScreen screen;

    @Override
    public PersonProfileView handle(PersonProfile personProfile) {
        return screen.findOne(personProfile.getPersonId());
    }

    @EventHandler
    private void on(PersonRegistered event) {
        screen.save(new PersonProfileView()
                .personId(event.getPersonId())
                .title(event.getTitle())
                .firstName(event.getFirstName())
                .lastName(event.getLastName())
                .birthday(event.getBirthday())
                .gender(event.getGender()));
    }

    @EventHandler
    private void on(SexChanged sexChanged) {
        screen.save(screen.findOne(sexChanged.getPersonId()).gender(sexChanged.getGender()));
    }

    @EventHandler
    private void on(ThingBought thingBought) {
        screen.save(screen.findOne(thingBought.getPersonId()).spent(thingBought.getCost()));
    }

    @Autowired
    public void setScreen(PersonProfileScreen screen) {
        this.screen = screen;
    }

    @Override
    public void beforeReplay() {
        screen.deleteAll();
    }

    @Override
    public void afterReplay() {
    }
}
