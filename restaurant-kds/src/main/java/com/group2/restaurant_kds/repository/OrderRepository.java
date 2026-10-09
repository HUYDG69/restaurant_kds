package com.group2.restaurant_kds.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group2.restaurant_kds.entity.Order;

@Repository 
public interface OrderRepository extends JpaRepository <Order,Long>{
    List<Order> findByStatus(String status);
    Optional<Order> findTopByTableIdAndStatusNotIn(Long tableId, List<String> statuses);
}