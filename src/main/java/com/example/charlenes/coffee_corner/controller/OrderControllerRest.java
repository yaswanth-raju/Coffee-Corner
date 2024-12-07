package com.example.charlenes.coffee_corner.controller;

import com.example.charlenes.coffee_corner.model.CustomerOrder;
import com.example.charlenes.coffee_corner.service.CoffeeShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordersRest")
public class OrderControllerRest {
    @Autowired
    private CoffeeShopService coffeeShopService;

    @PostMapping
    public CustomerOrder addOrder(@RequestBody CustomerOrder CustomerOrder) {
        return coffeeShopService.addOrder(CustomerOrder);
    }

    @GetMapping
    public List<CustomerOrder> getAllOrders() {
        return coffeeShopService.getAllOrders();
    }
}