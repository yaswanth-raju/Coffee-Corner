package com.example.charlenes.coffee_corner.dao;

import com.example.charlenes.coffee_corner.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long>{

//    @Query("select * from CustomerOrder order by date desc limit 1")
    CustomerOrder findTopByOrderByDateDesc();
}