package com.techelevator.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public List<Product> read(String fileName) {

        List<Product> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line = "";

            while ((line = br.readLine()) != null) {
                String[] values = line.split("\\|");
                Product product = new Product(values[0], values[1], Double.parseDouble(values[2]), values[3], 5);
                products.add(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }
}
