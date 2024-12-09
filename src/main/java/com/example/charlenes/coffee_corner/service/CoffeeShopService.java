package com.example.charlenes.coffee_corner.service;

import com.example.charlenes.coffee_corner.dao.AddonRepository;
import com.example.charlenes.coffee_corner.dao.CustomerOrderRepository;
import com.example.charlenes.coffee_corner.dao.ProductRepository;
import com.example.charlenes.coffee_corner.model.Addon;
import com.example.charlenes.coffee_corner.model.CustomerOrder;
import com.example.charlenes.coffee_corner.model.Product;
import com.example.charlenes.coffee_corner.model.ProductForm;
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

    public void placeOrder(List<ProductForm> productOrders) {
        log.info("Orders list", productOrders);
        CustomerOrder customerOrder=new CustomerOrder();
        //TODO
        customerOrderRepository.save(customerOrder);
    }
}
