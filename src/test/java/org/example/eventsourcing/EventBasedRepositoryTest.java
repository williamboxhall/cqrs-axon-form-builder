package org.example.eventsourcing;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EventBasedRepositoryTest {
    @Mock
    private AggregateRoot aggregateRoot;
    @Mock
    private List<Event> changes;
    @Mock
    private EventStore eventStore;
    private EventBasedRepository<AggregateRoot> repository;

    @Before
    public void setUp() {
        repository = new EventBasedRepository<AggregateRoot>(eventStore);
    }

    @Test
    public void savesAggregatesUncommittedEvents() {
        when(aggregateRoot.getChanges()).thenReturn(changes);
        repository.save(aggregateRoot);
        verify(eventStore).saveEvents(aggregateRoot.getGuid(), aggregateRoot.getChanges());
    }
}
