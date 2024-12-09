package com.example.charlenes.coffee_corner.service;

import com.example.charlenes.coffee_corner.model.ProductForm;

import java.util.List;

public class OrderForm {
    private List<ProductForm> productOrders;

    // Constructors
    public OrderForm() {}

    // Getters and setters
    public List<ProductForm> getProductOrders() {
        return productOrders;
    }

    public void setProductOrders(List<ProductForm> productOrders) {
        this.productOrders = productOrders;
    }

//    public static class ProductOrder {
//        private Long id;
//        private String name;
//        private String volume;
//        private double price;
//        private ProductType productType;
//        private List<Long> addons;
//
//        // Constructors
//        public ProductOrder() {}
//
//        public ProductOrder(Long id, String name, String volume, double price, ProductType productType, List<Long> addons) {
//            this.id = id;
//            this.name = name;
//            this.volume = volume;
//            this.price = price;
//            this.productType = productType;
//            this.addons = addons;
//        }
//
//        // Getters and setters
//        public Long getId() {
//            return id;
//        }
//
//        public void setId(Long id) {
//            this.id = id;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getVolume() {
//            return volume;
//        }
//
//        public void setVolume(String volume) {
//            this.volume = volume;
//        }
//
//        public double getPrice() {
//            return price;
//        }
//
//        public void setPrice(double price) {
//            this.price = price;
//        }
//
//        public ProductType getProductType() {
//            return productType;
//        }
//
//        public void setProductType(ProductType productType) {
//            this.productType = productType;
//        }
//
//        public List<Long> getAddons() {
//            return addons;
//        }
//
//        public void setAddons(List<Long> addons) {
//            this.addons = addons;
//        }
//    }
}
