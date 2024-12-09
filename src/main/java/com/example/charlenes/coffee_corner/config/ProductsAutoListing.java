package com.example.charlenes.coffee_corner.config;


import com.example.charlenes.coffee_corner.dao.AddonRepository;
import com.example.charlenes.coffee_corner.dao.ProductRepository;
import com.example.charlenes.coffee_corner.model.Addon;
import com.example.charlenes.coffee_corner.model.Product;
import com.example.charlenes.coffee_corner.model.ProductType;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
class ProductsKickstart {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AddonRepository addonRepository;

    @PostConstruct
    public void init() {
        Addon extraMilk = new Addon("Extra Milk", 0.30);
        Addon foamedMilk = new Addon("Foamed Milk", 0.50);
        Addon specialRoast = new Addon("Special Roast Coffee", 0.90);
        List<Addon> addons=Arrays.asList(extraMilk,foamedMilk,specialRoast);
        List<Product> products = Arrays.asList(
                new Product("Small Coffee", "250ml", 2.50, ProductType.BAVERAGE, null),
                new Product("Medium Coffee", "350ml", 3.00, ProductType.BAVERAGE, null),
                new Product("Large Coffee", "450ml", 3.50, ProductType.BAVERAGE, null),
                new Product("Bacon Roll", "1 roll", 4.50, ProductType.FOOD, null),
                new Product("Orange Juice", "250ml", 3.95, ProductType.BAVERAGE, null)
//                new Product("Extra Milk", "N/A", 0.30, ProductType.ADDON, extraMilk),
//                new Product("Foamed Milk", "N/A", 0.50, ProductType.ADDON, foamedMilk),
//                new Product("Special Roast Coffee", "N/A", 0.90, ProductType.ADDON, specialRoast)
        );
        productRepository.saveAll(products);
        addonRepository.saveAll(addons);
    }
}
