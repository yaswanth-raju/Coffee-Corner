package com.example.charlenes.coffee_corner.controller;


import com.example.charlenes.coffee_corner.model.CustomerOrder;
import com.example.charlenes.coffee_corner.service.CoffeeShopService;
import com.example.charlenes.coffee_corner.service.OrderForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String placeOrder(@RequestBody OrderForm orderForm) {
        coffeeShopService.placeOrder(orderForm.getProductOrders());
        return "redirect:/orders";
    }
}
