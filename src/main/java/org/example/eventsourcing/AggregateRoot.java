package org.example.eventsourcing;

import java.util.List;

import com.google.common.collect.Lists;


public abstract class AggregateRoot {
    private List<Event> changes = Lists.newArrayList();
    private Guid guid;

    List<Event> getChanges() {
        return changes;
    }
    
    public abstract Guid getGuid();
//
//    public void loadFromHistory(Iterable<Event> changes) {
//        for (Event change : changes) {
//            applyChange(change, false);
//        }
//    }
//
//    private void applyChange(Event change, boolean isNew) {
//        //To change body of created methods use File | Settings | File Templates.
//    }
}
