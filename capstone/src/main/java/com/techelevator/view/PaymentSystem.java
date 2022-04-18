package com.techelevator.view;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import static com.techelevator.view.Currency.*;

public class PaymentSystem {

    private double currentBalance;


    public double getCurrentBalance() {
        return currentBalance;
    }


    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public PaymentSystem() {
        this.currentBalance = currentBalance;
    }

    public void insertMoney(Currency dollar) {
        currentBalance += dollar.getValue();
        System.out.println("Current Money Provided $" + String.format("%,.2f", currentBalance));
        PurchaseLog.log("FEED MONEY: ", dollar.getValue(), currentBalance);
    }

    public String calculateChange() {
        double balanceBeforeChange = currentBalance;
        DecimalFormat df = new DecimalFormat(".##");
        int numberOfQuarters = 0;
        int numberOfDimes = 0;
        int numberOfNickels = 0;

        if (currentBalance > 0) {
            numberOfQuarters = (int)(currentBalance / QUARTER.getValue());
            currentBalance = Double.parseDouble(df.format(currentBalance % QUARTER.getValue()));
            numberOfDimes = (int)(currentBalance / DIME.getValue());
            currentBalance = Double.parseDouble(df.format(currentBalance % DIME.getValue()));
            numberOfNickels = (int)(currentBalance / NICKEL.getValue());
            currentBalance = Double.parseDouble(df.format(currentBalance % NICKEL.getValue()));

            PurchaseLog.log("GIVE CHANGE: ", balanceBeforeChange, currentBalance);
        }

        return "Your change is: \n" +
                "[" + numberOfQuarters +"]" + " quarter(s)\n"
                + "[" + numberOfDimes +"]" + " dime(s)\n"
                + "[" + numberOfNickels +"]" + " nickel(s)\n"
                + "Balance: $" + String.format("%,.2f", currentBalance);
    }



    public void dispenseProduct(Product product) {

        if (product.getQuantity() == 0) {
            System.out.println("Product is sold out! Please make another selection.");
        } else if (product.getPrice() <= currentBalance) {
            PurchaseLog.log(product.getProductName() + " " + product.getSlotID() + " ", currentBalance, currentBalance - product.getPrice());
            currentBalance -= product.getPrice();
            product.subtractQuantity();
            System.out.println("Dispense: " + product.getProductName() + " $" + String.format("%,.2f", product.getPrice())
                    + "\nYour balance is: $" + String.format("%,.2f", currentBalance)
                    + "\n----" + product.sound(product.getProductType()) + "----");
        } else {
            System.out.println("Insufficient funds!");
        }
    }
}