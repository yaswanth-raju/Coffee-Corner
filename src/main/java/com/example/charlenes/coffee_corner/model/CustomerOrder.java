package com.example.charlenes.coffee_corner.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@ToString
@Entity
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToMany(mappedBy = "customerOrder", cascade = CascadeType.ALL)
//    private List<OrderItem> orderItems;

    @OneToMany(cascade = CascadeType.ALL) @JoinColumn(name = "customer_order_id") // Foreign key column in OrderItem table
     private List<OrderItem> orderItems;

    private LocalDateTime date;

    private Long customerContact;

    private String customerName;

    private double totalPrice;

    @PrePersist
    @PreUpdate
    private void calculateTotalPrice() {
        this.totalPrice = orderItems.stream().mapToDouble(OrderItem::getTotalPrice).sum();
        this.date = LocalDateTime.now();
    }
}
