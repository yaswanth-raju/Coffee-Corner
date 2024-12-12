package com.example.charlenes.coffee_corner.service;

import com.example.charlenes.coffee_corner.repository.AddonRepository;
import com.example.charlenes.coffee_corner.repository.CustomerOrderRepository;
import com.example.charlenes.coffee_corner.repository.ProductRepository;
import com.example.charlenes.coffee_corner.forms.OrderForm;
import com.example.charlenes.coffee_corner.forms.ProductForm;
import com.example.charlenes.coffee_corner.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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

    List<ProductType> getBaverages() {
        return Arrays.asList(ProductType.MOCKTAIL, ProductType.CAFINE);
    }

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


    private List<Addon> getAddonsList(List<Long> addonIds) {
        return addonIds.stream().map(id -> addonRepository.findById(id).get()).toList();
    }

    public CustomerOrder getCurrentOrder() {
        // Add logic to retrieve the most recent order
        return customerOrderRepository.findTopByOrderByDateDesc();
    }


    public Integer getBeverageOrderCount(Long customerContact, List<ProductType> productTypes) {
        return customerOrderRepository.countBeverageOrdersByCustomerContactAndProductTypes(customerContact, productTypes);
    }

    private void applyOffers(CustomerOrder customerOrder) {
        Integer count = getBeverageOrderCount(customerOrder.getCustomerContact(), getBaverages());
        List<OrderItem> orderedBaverages = customerOrder.getOrderItems().stream().filter(orderItem -> getBaverages().indexOf(orderItem.getProduct().getProductType()) > -1).toList();
        if (orderedBaverages.size() > 0 && (count + 1) % 5 == 0) { //validating every 5 th order
            customerOrder.setIsDiscountEligble(true);
            customerOrder.setDiscountAmount(orderedBaverages.get(0).getProduct().getPrice());
            customerOrder.setDiscountDescription("It's your 5th order ,you got baverage is free worth : " + orderedBaverages.get(0).getProduct().getPrice());
            customerOrder.setTotalPriceAfterDiscount(customerOrder.getTotalPrice() - customerOrder.getDiscountAmount());
        }
    }

    public void placeOrder(OrderForm orderForm) {
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setCustomerName(orderForm.getCustomerName());
        customerOrder.setCustomerContact(orderForm.getCustomerContact());

        List<OrderItem> orderItems = new ArrayList<>();
        for (ProductForm productForm : orderForm.getProductOrders()) {
            Product product = productRepository.findById(productForm.getId()).orElse(null);
            if (product != null) {
                orderItems.add(new OrderItem(product, 1, getAddonsList(productForm.getAddons()))); // Add product item with quantity 1
            }
        }
        customerOrder.setOrderItems(orderItems);
        customerOrder.calculateTotalPrice();
        applyOffers(customerOrder);
        customerOrderRepository.save(customerOrder);
    }
}
