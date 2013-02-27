package org.example.events;

import org.example.eventsourcing.domain.Event;

public class ThingBought extends Event {
    private final String personId;
    private final String thing;
    private final double cost;

    public ThingBought(String personId, String thing, double cost) {
        this.personId = personId;
        this.thing = thing;
        this.cost = cost;
    }

    public String getPersonId() {
        return personId;
    }

    public String getThing() {
        return thing;
    }

    public double getCost() {
        return cost;
    }
}
