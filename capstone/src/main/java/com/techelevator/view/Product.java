package com.techelevator.view;

public class Product {


    private String slotID;
    private String productName;
    private Double price;
    private String productType;
    private int quantity;

    public Product() {

    }

    public Product(String slotID, String productName, Double price, String productType, int quantity) {
        this.slotID = slotID;
        this.productName = productName;
        this.price = price;
        this.productType = productType;
        this.quantity = quantity;
    }


    public String getSlotID() {
        return slotID;
    }

    public void setSlotID(String slotID) {
        this.slotID = slotID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void subtractQuantity() {
        quantity -= 1;
    }

    public String sound(String productType) {
        switch (productType) {
            case "Chip":
                return "Crunch Crunch, Yum!";
            case "Candy":
                return "Much Munch, Yum!";
            case "Drink":
                return "Glug Glug, Yum!";
            case "Gum":
                return "Chew Chew, Yum!";
            default:
                return "Uh-Oh this type does not exist";
        }
    }

    @Override
    public String toString() {
        if (quantity > 0) {
            return String.format("%-6s%-20s%10.2f%10s", slotID, productName, price, quantity);
        } else {
            return "   > *** SOLD OUT *** <";
        }
    }
}
