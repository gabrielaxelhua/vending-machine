package com.techelevator.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    final static String VENDINGMACHINECSV = "vendingmachine.csv";

    List<Product> listProducts;

    Map<String, Product> productSelection = new HashMap<>();

    public List<Product> getListProducts() {
        return listProducts;
    }

    public Map<String, Product> getProductSelection() {
        return productSelection;
    }

    public Inventory() {
        CSVReader csv = new CSVReader();
        listProducts = csv.read(VENDINGMACHINECSV);
        createInventoryMap(listProducts);
    }

    public void createInventoryMap(List <Product> listProducts) {
        for (Product product : listProducts) {
            productSelection.put(product.getSlotID(), product);
        }
    }

    public void displayInventory(){
        System.out.printf("%-6s%-20s%10s%13s\n", "ID","Product","Price","Quantity");
        System.out.println("------------------------------------------------------");
        for (Product p : getListProducts()) {
            System.out.println(p);
        }
    }
}
