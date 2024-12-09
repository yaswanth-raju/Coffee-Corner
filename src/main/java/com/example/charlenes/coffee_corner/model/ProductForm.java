package com.example.charlenes.coffee_corner.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class ProductForm {
    private Long id;
    private String name;
    private String volume;
    private double price;
    @Enumerated(EnumType.STRING)
    private ProductType productType;
    private List<Integer> addons;
}
