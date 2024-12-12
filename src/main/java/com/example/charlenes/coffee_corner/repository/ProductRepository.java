package com.example.charlenes.coffee_corner.repository;

import com.example.charlenes.coffee_corner.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
