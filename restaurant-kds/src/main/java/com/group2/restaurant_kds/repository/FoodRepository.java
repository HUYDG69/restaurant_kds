package com.group2.restaurant_kds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group2.restaurant_kds.entity.Food;

@Repository 
public interface FoodRepository extends JpaRepository<Food,Long>{
    List<Food> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String name, String description);
    List<Food> findByCategoryId (Long id);
}

