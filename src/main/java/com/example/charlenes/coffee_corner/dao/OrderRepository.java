package com.example.charlenes.coffee_corner.dao;

import com.example.charlenes.coffee_corner.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<CustomerOrder, Long>{

}