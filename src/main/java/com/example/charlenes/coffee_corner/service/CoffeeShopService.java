package com.example.charlenes.coffee_corner.service;

import com.example.charlenes.coffee_corner.dao.AddonRepository;
import com.example.charlenes.coffee_corner.dao.CustomerOrderRepository;
import com.example.charlenes.coffee_corner.dao.ProductRepository;
import com.example.charlenes.coffee_corner.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CoffeeShopService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @Autowired
    private AddonRepository addonRepository;

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
        return customerOrderRepository.save(customerOrder);
    }

    public List<CustomerOrder> getAllOrders() {
        return customerOrderRepository.findAll();
    }

    public List<Addon> getAllAddons() {
        return addonRepository.findAll();
    }

    public void placeOrder(OrderForm orderForm) {
        List<OrderItem> orderItems = new ArrayList<>();
        CustomerOrder customerOrder = new CustomerOrder();

        for (ProductForm productForm : orderForm.getProductOrders()) {
            Product product = productRepository.findById(productForm.getId()).orElse(null);
            if (product != null) {
                orderItems.add(new OrderItem(customerOrder, product, 1,getAddonsList(productForm.getAddonIds()))); // Add product item with quantity 1
            }
        }

        customerOrder.setOrderItems(orderItems);
        customerOrder.setCustomerId(1l);
        customerOrderRepository.save(customerOrder);
    }

    private List<Addon> getAddonsList(List<Long> addonIds) {
        return addonIds.stream().map(id->addonRepository.findById(id).get()).toList();
    }
    public CustomerOrder getCurrentOrder() {
        // Add logic to retrieve the most recent order
        return customerOrderRepository.findTopByOrderByDateDesc();
    }

}
