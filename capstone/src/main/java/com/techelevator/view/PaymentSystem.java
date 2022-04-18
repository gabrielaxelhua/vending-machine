package com.techelevator.view;

public class PaymentSystem {


    private double currentBalance;


    public double getCurrentBalance() {
        return currentBalance;
    }

    public PaymentSystem() {
        this.currentBalance = currentBalance;
    }

    public void insertMoney(Currency dollar) {
        currentBalance += dollar.getValue();
        System.out.println("Current Money Provided $" + String.format("%,.2f", currentBalance));
        PurchaseLog.log("FEED MONEY: ", dollar.getValue(), currentBalance);
    }

//TODO uncomment if you remove dispense method from this class
//    public void subtractMoney(double coins) {
//        currentBalance -= coins;
////        System.out.println("Your change is $" + String.format("%,.2f", currentBalance));
//    }

    public String calculateChange() {
        double balanceBeforeChange = currentBalance;
        int numberOfQuarters = 0;
        int numberOfDimes = 0;
        int numberOfNickels = 0;

        while (currentBalance > 0) {
            if (currentBalance >= Currency.QUARTER.getValue()) {
                currentBalance -= Math.round(Currency.QUARTER.getValue());
                numberOfQuarters++;
            } else if (currentBalance >= Currency.DIME.getValue()) {
                currentBalance -= Math.round(Currency.DIME.getValue());
                numberOfDimes++;
            } else if (currentBalance >= Currency.NICKEL.getValue()) {
                currentBalance -= Math.round(Currency.NICKEL.getValue());
                numberOfNickels++;
            }
        }
        PurchaseLog.log("GIVE CHANGE: ", balanceBeforeChange, currentBalance);
        return "Your change is:\n"
                + "[" + numberOfQuarters + "]" + " quarter(s)\n"
                + "[" + numberOfDimes + "]" + " dime(s)\n"
                + "[" + numberOfNickels + "]" + " nickel(s)\n"
                + "Balance: " + String.format("%,.2f", currentBalance) + "Actual" + currentBalance;
    }


//    public void calculateChange() {
//        int changeDue = (int) currentBalance * 100;
//        int numberOfQuarters = 0;
//        int numberOfDimes = 0;
//        int numberOfNickels = 0;
//
//      if (currentBalance >= 0) {
//            if (currentBalance >= Currency.QUARTER.getValue()) {
//                numberOfQuarters = (int) (currentBalance / Currency.QUARTER.getValue());
//               currentBalance = (double) Math.round(currentBalance % Currency.QUARTER.getValue());
//            }
//            else if (currentBalance >= Currency.DIME.getValue()) {
//                numberOfDimes = (int) (currentBalance / Currency.DIME.getValue());
//                currentBalance = (double) Math.round(currentBalance % Currency.DIME.getValue());
//
//            }
//            else if (currentBalance >= Currency.NICKEL.getValue()) {
//                numberOfNickels = (int) (currentBalance / Currency.NICKEL.getValue());
//                currentBalance = (double) Math.round(currentBalance % Currency.NICKEL.getValue());
//            }
//        }
//        System.out.println("Your change is: ");
//        System.out.println("[" + numberOfQuarters +"]" + " quarter(s)");
//        System.out.println("[" + numberOfDimes +"]" + " dime(s)");
//        System.out.println("[" + numberOfNickels +"]" + " nickel(s)");
//        System.out.println("Balance: " + String.format("%,.2f", currentBalance) + "Actual" + currentBalance);
//        PurchaseLog.log("GIVE CHANGE: ", balanceBeforeChange, currentBalance);
//    }

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


//    public void calculateChange() {
//        double startingBalance = currentBalance;
//        int numberOfQuarters = 0;
//        int numberOfDimes = 0;
//        int numberOfNickels = 0;
//
//        while (currentBalance > 0) {
//            if (currentBalance >= Currency.QUARTER.getValue()) {
//                currentBalance -= Currency.QUARTER.getValue();
//                numberOfQuarters++;
//            }
//            else if (currentBalance >= Currency.DIME.getValue()) {
//                currentBalance -= Currency.DIME.getValue();
//                numberOfDimes++;
//            }
//            else if (currentBalance >= Currency.NICKEL.getValue()) {
//                currentBalance -= Currency.NICKEL.getValue();
//                numberOfNickels++;
//            }
//        }
//        System.out.println("Your change is: ");
//        System.out.println("[" + numberOfQuarters +"]" + " quarter(s)");
//        System.out.println("[" + numberOfDimes +"]" + " dime(s)");
//        System.out.println("[" + numberOfNickels +"]" + " nickel(s)");
//        System.out.println("Balance: " + String.format("%,.2f", currentBalance) + "Actual" + currentBalance);
//        PurchaseLog.log("GIVE CHANGE: ", startingBalance, currentBalance);
//    }
