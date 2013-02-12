package org.example.write.commands;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import org.example.eventsourcing.domain.Command;

public class BuyThing implements Command {
    @TargetAggregateIdentifier
    private String personId;
    private String thing;

    public BuyThing() {
    }

    public BuyThing(String thing) {
        this.thing = thing;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getThing() {
        return thing;
    }

    public void setThing(String thing) {
        this.thing = thing;
    }
}
