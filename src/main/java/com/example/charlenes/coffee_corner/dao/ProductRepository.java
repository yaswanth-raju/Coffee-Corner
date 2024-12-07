package com.example.charlenes.coffee_corner.dao;

import com.example.charlenes.coffee_corner.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

}
