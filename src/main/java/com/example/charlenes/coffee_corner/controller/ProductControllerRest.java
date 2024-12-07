package com.example.charlenes.coffee_corner.controller;

import com.example.charlenes.coffee_corner.model.Product;
import com.example.charlenes.coffee_corner.service.CoffeeShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductControllerRest {
    @Autowired
    private CoffeeShopService coffeeShopService;

    @GetMapping(path = "getAllProducts")
    public List<Product> getAllProducts() {
        return coffeeShopService.getAllProducts();
    }

    @PutMapping(path = "createProduct")
    public Product createProduct(@RequestBody Product product) {

        return coffeeShopService.createProduct(product);
    }
    @PutMapping(path = "updateProduct")
    public Product updateProduct(@RequestBody Product product){
        return coffeeShopService.updateProduct(product);
    }
}