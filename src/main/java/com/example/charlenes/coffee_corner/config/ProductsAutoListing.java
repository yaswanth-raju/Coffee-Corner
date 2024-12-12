package com.example.charlenes.coffee_corner.config;


import com.example.charlenes.coffee_corner.repository.AddonRepository;
import com.example.charlenes.coffee_corner.repository.ProductRepository;
import com.example.charlenes.coffee_corner.model.Addon;
import com.example.charlenes.coffee_corner.model.Product;
import com.example.charlenes.coffee_corner.model.ProductType;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
class ProductsAutoListing {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AddonRepository addonRepository;

    @PostConstruct
    public void init() {
        Addon extraMilk = new Addon("Extra Milk", 0.30,ProductType.CAFINE);
        Addon foamedMilk = new Addon("Foamed Milk", 0.50,ProductType.CAFINE);
        Addon specialRoast = new Addon("Special Roast Coffee", 0.90,ProductType.CAFINE);
        Addon extraSauce = new Addon("Extra Sauce", 0.10,ProductType.FOOD);
        Addon extraSweet = new Addon("Extra Sweet", 0.05,ProductType.MOCKTAIL);
        List<Addon> Addons =Arrays.asList(extraMilk,foamedMilk,specialRoast,extraSauce,extraSweet);
        List<Product> products = Arrays.asList(
                new Product("Small Coffee", "250ml", 2.50, ProductType.CAFINE),
                new Product("Medium Coffee", "350ml", 3.00, ProductType.CAFINE),
                new Product("Large Coffee", "450ml", 3.50, ProductType.CAFINE),
                new Product("Bacon Roll", "1 roll", 4.50, ProductType.FOOD),
                new Product("Orange Juice", "250ml", 3.95, ProductType.MOCKTAIL)
        );
        productRepository.saveAll(products);
        addonRepository.saveAll(Addons);
    }
}
