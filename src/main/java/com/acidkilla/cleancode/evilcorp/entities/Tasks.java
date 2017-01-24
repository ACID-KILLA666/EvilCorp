package com.acidkilla.cleancode.evilcorp.entities;

/**
 * Created by Aurelien on 22-Jan-17.
 */
public enum Tasks {
    WORK ("Work"),
    EAT ("Eat"),
    SLEEP ("Sleep"),
    STANDBY ("Standby"),
    OTHER ("Other");

    private final String name;

    Tasks(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}
