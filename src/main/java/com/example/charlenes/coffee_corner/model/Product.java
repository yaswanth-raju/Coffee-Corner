package com.example.charlenes.coffee_corner.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String volume;
    private double price;

    @Enumerated(EnumType.STRING)
    private ProductType productType;

    public Product(String name, String volume, double price, ProductType productType) {
        this.name = name;
        this.volume = volume;
        this.price = price;
        this.productType = productType;
    }
}
