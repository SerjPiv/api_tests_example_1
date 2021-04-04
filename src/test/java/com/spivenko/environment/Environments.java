package com.spivenko.environment;

public enum Environments {
    DOCKERISED,
    LIVE,
    TEST;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}