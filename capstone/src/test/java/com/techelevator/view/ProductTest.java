package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void soundTest() {
        //Arrange
        Product product = new Product("A1", "CocaCola", 1.25, "Drink", 5);

        //Act
        String expectedOutput = "Glug Glug, Yum!";

        //Assert
        Assert.assertEquals(expectedOutput, product.sound(product.getProductType()));
    }

    @Test
    public void toStringTest() {
        //Arrange
        Product product = new Product("A1", "CocaCola", 1.25, "Drink", 0);

        //Act
        String expectedOutput = "   > *** SOLD OUT *** <";

        //Assert
        Assert.assertEquals(expectedOutput, product.toString());
    }

}