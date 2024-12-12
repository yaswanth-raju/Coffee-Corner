package com.example.charlenes.coffee_corner.repository;

import com.example.charlenes.coffee_corner.model.CustomerOrder;
import com.example.charlenes.coffee_corner.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long>{

//    @Query("select * from CustomerOrder order by date desc limit 1")
    CustomerOrder findTopByOrderByDateDesc();
     @Query("SELECT COUNT(oi) FROM CustomerOrder co JOIN co.orderItems oi WHERE co.customerContact = :customerContact AND oi.product.productType IN :productTypes")
     Integer countBeverageOrdersByCustomerContactAndProductTypes(@Param("customerContact") Long customerContact, @Param("productTypes") List<ProductType> productTypes);
}