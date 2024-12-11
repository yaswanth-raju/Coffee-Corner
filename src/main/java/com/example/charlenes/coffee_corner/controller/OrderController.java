package com.example.charlenes.coffee_corner.controller;

import com.example.charlenes.coffee_corner.model.CustomerOrder;
import com.example.charlenes.coffee_corner.service.CoffeeShopService;
import com.example.charlenes.coffee_corner.service.OrderForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private CoffeeShopService coffeeShopService;

    @GetMapping
    public String showOrderForm(Model model) {
        model.addAttribute("products", coffeeShopService.getAllProducts());
        model.addAttribute("addons", coffeeShopService.getAllAddons());
        model.addAttribute("orderForm", new OrderForm());
        return "order";
    }

    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody OrderForm orderForm) {
        coffeeShopService.placeOrder(orderForm);
        return new ResponseEntity<>("Order placed successfully!", HttpStatus.OK);
    }

    @GetMapping("/list")
    public String listOrders(Model model) {
        List<CustomerOrder> orders = coffeeShopService.getAllOrders();
        model.addAttribute("orders", orders);
        return "orderList";
//        return "orderListSimpl";
    }
    @GetMapping("/current")
    public String showCurrentOrder(Model model) {
        // Assuming we have a method to get the most recent order
        CustomerOrder currentOrder = coffeeShopService.getCurrentOrder();
        model.addAttribute("currentOrder", currentOrder);
        return "currentOrder";
    }
}
