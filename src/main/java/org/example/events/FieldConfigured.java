package org.example.events;

public abstract class FieldConfigured {
    private final String guid;
    private final String name;
    private final String label;
    private final String hintText;

    public FieldConfigured(String guid, String name, String label, String hintText) {
        this.guid = guid;
        this.name = name;
        this.label = label;
        this.hintText = hintText;
    }

    public String getGuid() {
        return guid;
    }

    public String getName() {
        return name;
    }

    public String getLabel() {
        return label;
    }

    public String getHintText() {
        return hintText;
    }
}
