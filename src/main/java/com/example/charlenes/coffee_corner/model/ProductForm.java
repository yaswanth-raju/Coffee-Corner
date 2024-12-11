package com.example.charlenes.coffee_corner.model;

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
    List<Long> addonIds;
}
