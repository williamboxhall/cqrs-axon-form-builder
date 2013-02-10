package org.example.write.commands;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import org.example.eventsourcing.domain.Command;

public class BuyThing implements Command {
    @TargetAggregateIdentifier
    private String guid;
    private String thing;

    public BuyThing() {
    }

    public BuyThing(String thing) {
        this.thing = thing;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getThing() {
        return thing;
    }

    public void setThing(String thing) {
        this.thing = thing;
    }
}
