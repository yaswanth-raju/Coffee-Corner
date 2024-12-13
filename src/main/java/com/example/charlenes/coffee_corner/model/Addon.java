package com.example.charlenes.coffee_corner.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
public class Addon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;

    @Enumerated(EnumType.STRING)
    private ProductType productType;

    public Addon(String name, double price,ProductType productType) {
        this.name = name;
        this.price = price;
        this.productType = productType;
    }
}
