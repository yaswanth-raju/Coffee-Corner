package com.example.charlenes.coffee_corner.controller;

import com.example.charlenes.coffee_corner.model.CustomerOrder;
import com.example.charlenes.coffee_corner.service.CoffeeShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/current")
public class CurrentOrderController {

    @Autowired
    private CoffeeShopService coffeeShopService;

//    @GetMapping("/current")
//    public String showCurrentOrder(Model model) {
//        // Assuming we have a method to get the most recent order
//        CustomerOrder currentOrder = coffeeShopService.getCurrentOrder();
//        model.addAttribute("currentOrder", currentOrder);
//        return "currentOrder";
//    }
}
