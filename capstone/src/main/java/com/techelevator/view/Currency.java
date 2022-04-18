package com.techelevator.view;

public enum Currency {

    NICKEL(0.05),
    DIME(0.10),
    QUARTER(0.25),
    ONE_DOLLAR(1.00),
    TWO_DOLLAR(2.00),
    FIVE_DOLLAR(5.00),
    TEN_DOLLAR(10.00);

    private final double value;

    Currency(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
