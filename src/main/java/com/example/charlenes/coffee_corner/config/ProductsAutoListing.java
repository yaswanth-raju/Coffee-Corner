package com.example.charlenes.coffee_corner.config;

import com.example.charlenes.coffee_corner.dao.ProductRepository;
import com.example.charlenes.coffee_corner.model.Product;
import com.example.charlenes.coffee_corner.model.ProductType;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class ProductsAutoListing {

    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    public void init() {
        List<Product> products = Arrays.asList(
                new Product("Small Coffee", "250ml", 2.50, ProductType.BASIC),
                new Product("Medium Coffee", "350ml", 3.00, ProductType.BASIC),
                new Product("Large Coffee", "450ml", 3.50, ProductType.BASIC),
                new Product("Bacon Roll", "1 roll", 4.50, ProductType.BASIC),
                new Product("Orange Juice", "250ml", 3.95, ProductType.BASIC),
                new Product("Extra Milk", "N/A", 0.30, ProductType.ADDON),
                new Product("Foamed Milk", "N/A", 0.50, ProductType.ADDON),
                new Product("Special Roast Coffee", "N/A", 0.90, ProductType.ADDON)
        );
        productRepository.saveAll(products);
    }
}
