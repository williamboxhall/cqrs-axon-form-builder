package org.example.write.commands;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import org.example.eventsourcing.domain.Command;

public class ChangeSex implements Command {
    @TargetAggregateIdentifier
    private String personId;
    private String gender;

    public ChangeSex() {
    }

    public ChangeSex(String personId, String gender) {
        this.personId = personId;
        this.gender = gender;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
