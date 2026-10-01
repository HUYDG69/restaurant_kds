package com.group2.restaurant_kds.service;

import java.util.List;
import com.group2.restaurant_kds.dto.food.FoodResponseDTO;
import com.group2.restaurant_kds.dto.food.FoodRequestDTO;
public interface  FoodService {
    List<FoodResponseDTO> getAllFoods(); 
    FoodResponseDTO getFoodById(Long id);
    FoodResponseDTO createFood (FoodRequestDTO dto);
    FoodResponseDTO updateFood (Long id, FoodRequestDTO dto);
    void deleteFood (Long id);
    List<FoodResponseDTO> searchFoods (String keyword);
    List<FoodResponseDTO> getFoodsByCategory(Long categoryId);
}
