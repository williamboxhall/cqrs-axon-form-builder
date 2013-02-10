package org.example.write.commands;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import org.example.eventsourcing.domain.Command;

public class ChangeSex implements Command {
    @TargetAggregateIdentifier
    private String guid;
    private String gender;

    public ChangeSex() {
    }

    public ChangeSex(String guid, String gender) {
        this.guid = guid;
        this.gender = gender;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
