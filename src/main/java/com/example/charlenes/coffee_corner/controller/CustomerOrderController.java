package com.example.charlenes.coffee_corner.controller;

import com.example.charlenes.coffee_corner.model.CustomerOrder;
import com.example.charlenes.coffee_corner.service.CoffeeShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customerOrders")
public class CustomerOrderController {
    @Autowired
    private CoffeeShopService coffeeShopService;

    @GetMapping
    public List<CustomerOrder> getAllOrders() {
        return coffeeShopService.getAllOrders();
    }
}