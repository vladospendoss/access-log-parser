package ru.courses.food;

public enum SpicyLevel {
    VERY_SPICY("Очень острый"),SPICY("Острый"),NOT_SPICY("Не острый");

    final String spicyLevel;

    SpicyLevel(String spicyLevel) {
        this.spicyLevel = spicyLevel;
    }
}
