package com.company.model;

public enum Department {
    IT(1),
    HR(2),
    SALES(3);
    private int value;

    Department(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
