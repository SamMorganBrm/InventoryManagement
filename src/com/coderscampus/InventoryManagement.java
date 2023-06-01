package com.coderscampus;

import com.coderscampus.domain.Product;
import com.coderscampus.services.CSVReader;
import com.coderscampus.services.ReportGenerator;
import java.nio.file.Path;
import java.util.ArrayList;

public class InventoryManagement {

    public static void main(String[] args) {
        CSVReader csv = CSVReader.getInstance();
        ArrayList<Product> products =new ArrayList(csv.readProductsFromFile(Path.of("products.txt")));
        ReportGenerator report = new ReportGenerator();
        report.generateLowInventoryReport(products);
        
    }
    
}
