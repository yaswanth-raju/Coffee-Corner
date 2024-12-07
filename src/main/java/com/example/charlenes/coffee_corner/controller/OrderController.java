package com.example.charlenes.coffee_corner.controller;


import com.example.charlenes.coffee_corner.model.CustomerOrder;
import com.example.charlenes.coffee_corner.service.CoffeeShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private CoffeeShopService coffeeShopService;

    @GetMapping
    public String showOrderForm(Model model) {
        model.addAttribute("products", coffeeShopService.getAllProducts());
        model.addAttribute("orderForm", new CustomerOrder());
        return "order";
    }

    @PostMapping
    public String placeOrder(@ModelAttribute CustomerOrder orderForm) {
        coffeeShopService.addOrder(orderForm);
        return "redirect:/orders";
    }
}
