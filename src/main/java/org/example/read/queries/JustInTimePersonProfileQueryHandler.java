package org.example.read.queries;

import org.axonframework.domain.DomainEventStream;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.SimpleEventBus;
import org.axonframework.eventhandling.annotation.AnnotationEventListenerAdapter;
import org.axonframework.eventstore.EventStore;
import org.example.eventsourcing.domain.QueryHandler;
import org.example.read.projectors.PersonProfileProjector;
import org.example.read.views.PersonProfileScreen;
import org.example.read.views.PersonProfileView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JustInTimePersonProfileQueryHandler implements QueryHandler<PersonProfileView, JustInTimePersonProfileQuery> {
    private final EventStore eventStore;

    @Autowired
    public JustInTimePersonProfileQueryHandler(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    @Override
    public PersonProfileView handle(JustInTimePersonProfileQuery query) {
        PersonProfileProjector projector = new PersonProfileProjector();
        PersonProfileScreen screen = transientScreen();
        projector.setScreen(screen);
        EventBus eventBus = new SimpleEventBus();
        AnnotationEventListenerAdapter.subscribe(projector, eventBus);
        DomainEventStream domainEventStream = eventStore.readEvents("Person", query.getPersonId());
        while (domainEventStream.hasNext()) {
            eventBus.publish(domainEventStream.next());
        }
        return screen.findOne(query.getPersonId());
    }

    private PersonProfileScreen transientScreen() {
        return new PersonProfileScreen() {
            public PersonProfileView entity;

            @Override
            public PersonProfileView save(PersonProfileView entity) {
                this.entity = entity;
                return entity;
            }

            @Override
            public PersonProfileView findOne(String id) {
                return entity;
            }

            @Override
            public Iterable<PersonProfileView> save(Iterable<? extends PersonProfileView> entities) {
                throw new UnsupportedOperationException();
            }

            @Override
            public boolean exists(String s) {
                throw new UnsupportedOperationException();
            }

            @Override
            public Iterable<PersonProfileView> findAll() {
                throw new UnsupportedOperationException();
            }

            @Override
            public long count() {
                throw new UnsupportedOperationException();
            }

            @Override
            public void delete(String s) {
                throw new UnsupportedOperationException();
            }

            @Override
            public void delete(PersonProfileView entity) {
                throw new UnsupportedOperationException();
            }

            @Override
            public void delete(Iterable<? extends PersonProfileView> entities) {
                throw new UnsupportedOperationException();
            }

            @Override
            public void deleteAll() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
