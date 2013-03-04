package org.example.read.projectors;

import static com.google.common.base.CaseFormat.LOWER_UNDERSCORE;
import static com.google.common.base.CaseFormat.UPPER_CAMEL;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.axonframework.domain.MetaData;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventhandling.replay.ReplayAware;
import org.example.events.PersonRegistered;
import org.example.events.SexChanged;
import org.example.events.ThingBought;
import org.example.eventsourcing.domain.Event;
import org.example.eventsourcing.domain.QueryHandler;
import org.example.read.queries.PersonEventStream;
import org.example.read.views.PersonEventView;
import org.example.read.views.PersonEventsScreen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonEventStreamProjector implements ReplayAware, QueryHandler<List<PersonEventView>, PersonEventStream> {
    private PersonEventsScreen screen;

    @Override
    public List<PersonEventView> handle(PersonEventStream query) {
        return screen.findByPersonIdOrderByEventDateAsc(query.getPersonId());
    }

    @EventHandler
    private void on(PersonRegistered event, MetaData metaData) {
        saveEventEntryFor(event.getPersonId(), event);
    }

    @EventHandler
    private void on(SexChanged event) {
        saveEventEntryFor(event.getPersonId(), event);
    }

    @EventHandler
    private void on(ThingBought event) {
        saveEventEntryFor(event.getPersonId(), event);
    }

    private void saveEventEntryFor(String personId, Event event) {
        // TODO get date off event
        screen.save(new PersonEventView(UUID.randomUUID(), personId, typeOf(event), new Date()));
    }

    private String typeOf(Event event) {
        return UPPER_CAMEL.to(LOWER_UNDERSCORE, event.getClass().getSimpleName()).replaceAll("_", " ");
    }

    @Autowired
    public void setScreen(PersonEventsScreen screen) {
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
