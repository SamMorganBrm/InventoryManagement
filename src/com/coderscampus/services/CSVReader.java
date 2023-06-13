package com.coderscampus.services;

import com.coderscampus.domain.Product;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    private static CSVReader csvReader = null;

    private CSVReader() {
    }

    public static CSVReader getInstance() {
        if (csvReader == null) {
            csvReader = new CSVReader();
        }
        return csvReader;
    }

    public List<Product> readProductsFromFile(Path filePath) {
        //List of the products
        List<Product> products = new ArrayList<>();

        try {
            //Reading products from file
            List<String> data = Files.readAllLines(filePath);
            data.stream().skip(1).forEach((String lineOfData) -> {
                Product product = new Product();
                String productData[] = lineOfData.split(",");
                product.setId(Integer.parseInt(productData[0]));
                product.setName(productData[1]);
                product.setQuantity(Integer.parseInt(productData[2]));
                product.setPrice(Double.parseDouble(productData[3]));
                products.add(product);
            }
            );
        } catch (IOException ex) {
            System.out.println("Error reading CSV File" + ex.getMessage());
        }
        return products;
    }
    
    
}
