package com.example.charlenes.coffee_corner.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_order_id")
    private CustomerOrder customerOrder;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;
    private double totalPrice;

    @PrePersist
    @PreUpdate
    private void calculateTotalPrice() {
        if (product != null) {
            this.totalPrice = product.getPrice() * quantity;
        }
    }

    public OrderItem() {}

    public OrderItem(CustomerOrder customerOrder, Product product, int quantity) {
        this.customerOrder = customerOrder;
        this.product = product;
        this.quantity = quantity;
        calculateTotalPrice();
    }
}
