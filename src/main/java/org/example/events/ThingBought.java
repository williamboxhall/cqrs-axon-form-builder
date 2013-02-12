package org.example.events;

public class ThingBought {
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
