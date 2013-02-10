package org.example.events;

public class ThingBought {
    private final String thing;
    private final double cost;

    public ThingBought(String thing, double cost) {
        this.thing = thing;
        this.cost = cost;
    }

    public String getThing() {
        return thing;
    }

    public double getCost() {
        return cost;
    }
}
