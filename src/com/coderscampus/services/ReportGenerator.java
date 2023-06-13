package com.coderscampus.services;

import com.coderscampus.domain.Product;
import java.util.ArrayList;
import java.util.List;

public class ReportGenerator {

    public void generateLowInventoryReport(ArrayList<Product> products) {
        List<Product> lowInventory = new ArrayList<>();

        for (Product product : products) {
            double price = product.getPrice();
            int quantity = product.getQuantity();
            if ((price >= 0.99 && price <= 100 && quantity <= 20)) {
                lowInventory.add(product);
            } else if (price >= 101.00 && quantity <= 10) {
                lowInventory.add(product);
            }
        }
        
        for (Product product : lowInventory) {
            System.out.println(product.toString());
        }
    }
}
