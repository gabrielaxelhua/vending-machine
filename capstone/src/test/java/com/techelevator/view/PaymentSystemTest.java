package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PaymentSystemTest {

    @Test
    public void calculateChangeTest() {

        //Arrange
        PaymentSystem ps = new PaymentSystem();
        ps.setCurrentBalance(2.15);

        //Act
        String expectedOutput = "Your change is: \n" +
                "[8] quarter(s)\n" +
                "[1] dime(s)\n" +
                "[1] nickel(s)\n" +
                "Balance: $0.00";

        //Assert
        Assert.assertEquals(expectedOutput, ps.calculateChange());
    }
}