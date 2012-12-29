package org.example.read.domain;

import org.example.events.PersonRegistered;
import org.example.events.SexChanged;
import org.example.eventsourcing.domain.View;

public class PersonProfileView extends View {
    public PersonProfileView() {
        super(PersonRegistered.class, SexChanged.class);
    }

    public void handle(PersonRegistered event) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void handle(SexChanged event) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
