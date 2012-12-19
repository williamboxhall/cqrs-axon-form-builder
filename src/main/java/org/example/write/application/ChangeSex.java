package org.example.write.application;

import org.example.eventsourcing.domain.Command;

public class ChangeSex implements Command {
    private String guid;
    private String gender;

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
