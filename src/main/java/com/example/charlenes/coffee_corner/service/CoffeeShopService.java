package com.example.charlenes.coffee_corner.service;

import com.example.charlenes.coffee_corner.dao.OrderRepository;
import com.example.charlenes.coffee_corner.dao.ProductRepository;
import com.example.charlenes.coffee_corner.model.CustomerOrder;
import com.example.charlenes.coffee_corner.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CoffeeShopService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;


    public Product createProduct(Product product) {

        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {

        return productRepository.save(product);
    }
    public List<Product> getAllProducts() {
        log.info("inside getting products ,writing my logic");
        return productRepository.findAll();
    }


    public CustomerOrder addOrder(CustomerOrder customerOrder) {
        return orderRepository.save(customerOrder);
    }

    public List<CustomerOrder> getAllOrders() {
       return orderRepository.findAll();
    }

}
