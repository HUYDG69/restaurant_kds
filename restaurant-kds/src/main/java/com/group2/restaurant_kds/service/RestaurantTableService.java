package com.group2.restaurant_kds.service;

import java.util.List;

import com.group2.restaurant_kds.dto.restaurantTable.RestaurantTableRequestDTO;
import com.group2.restaurant_kds.dto.restaurantTable.RestaurantTableResponseDTO;

public interface RestaurantTableService {

    List<RestaurantTableResponseDTO> getAllTables();
    RestaurantTableResponseDTO getTableById(Long id);
    RestaurantTableResponseDTO createTable(RestaurantTableRequestDTO dto);
    RestaurantTableResponseDTO updateTable(Long id, RestaurantTableRequestDTO dto);
    void deleteTable(Long id);
    RestaurantTableResponseDTO updateTableStatus(Long id, Boolean status);
}
