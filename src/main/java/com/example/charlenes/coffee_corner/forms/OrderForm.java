package com.example.charlenes.coffee_corner.forms;

import com.example.charlenes.coffee_corner.model.ProductType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class OrderForm {
    private Long customerContact;
    private String customerName;
    private List<ProductForm> productOrders;
}
