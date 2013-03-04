package org.example.write.commands;

import org.example.eventsourcing.domain.Command;

public class DoSomething implements Command {
    private String personId;
    private String something;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getSomething() {
        return something;
    }

    public void setSomething(String something) {
        this.something = something;
    }
}
