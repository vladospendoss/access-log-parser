package ru.courses.food;

public class Sauce {

    private final String name;
    private final SpicyLevel spicyLevel;

    public Sauce(String name, SpicyLevel spicyLevel) {
        this.name = name;
        this.spicyLevel = spicyLevel;
    }

    @Override
    public String toString() {
        return "Соус " + name + ": " + spicyLevel;
    }
}
