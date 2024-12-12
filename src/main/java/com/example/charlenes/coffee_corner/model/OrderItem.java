package com.example.charlenes.coffee_corner.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@ToString
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "customer_order_id")
//    @JsonIgnore
//    private CustomerOrder customerOrder;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    //    @OneToMany(mappedBy = "orderItem", cascade = CascadeType.ALL)
    @ManyToMany
    @JoinTable(name = "order_item_addon",
            joinColumns = @JoinColumn(name = "order_item_id"),
            inverseJoinColumns = @JoinColumn(name = "addon_id"))
    private List<Addon> addons;

    private int quantity;

    private double totalPrice;

    @PrePersist
    @PreUpdate
    private void calculateTotalPrice() {
        if (product != null) {
            this.totalPrice = getQuantity() * (
                    product.getPrice() +
                            getAddons().stream().map(addon -> addon.getPrice()).collect(Collectors.summingDouble(Double::doubleValue)));
        }
    }

    private OrderItem() {
    }

    public OrderItem(Product product, int quantity, List<Addon> addons) {
        this.product = product;
        this.quantity = quantity;
        this.addons = addons;
        calculateTotalPrice();
    }
}
