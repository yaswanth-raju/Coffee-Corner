package com.example.charlenes.coffee_corner.controller;


import com.example.charlenes.coffee_corner.model.Product;
import com.example.charlenes.coffee_corner.service.CoffeeShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private CoffeeShopService coffeeShopService;

    @GetMapping
    public String getAllProducts(Model model) {
        model.addAttribute("products", coffeeShopService.getAllProducts());
        model.addAttribute("product", new Product()); // For the form
        return "products";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute Product product) {
        coffeeShopService.createProduct(product);
        return "redirect:/products";
    }
}
