package com.example.charlenes.coffee_corner.model;

import com.example.charlenes.coffee_corner.service.OrderForm;
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

    @OneToMany(mappedBy = "customerOrder", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    private LocalDateTime date;

    private Long customerId;

    private double totalPrice;

    @PrePersist
    @PreUpdate
    private void calculateTotalPrice() {
        this.totalPrice = orderItems.stream().mapToDouble(OrderItem::getTotalPrice).sum();
        this.date = LocalDateTime.now();
    }
}
