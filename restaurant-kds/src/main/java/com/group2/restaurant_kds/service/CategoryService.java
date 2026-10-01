package com.group2.restaurant_kds.service;

import com.group2.restaurant_kds.dto.category.CategoryRequestDTO;
import com.group2.restaurant_kds.dto.category.CategoryResponseDTO;
import com.group2.restaurant_kds.entity.Category;


import java.util.List;

public interface CategoryService {
    List<CategoryResponseDTO> getAllCategories();
    CategoryResponseDTO createCategory(CategoryRequestDTO dto);
    CategoryResponseDTO categoryGetById(Long id);
    CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO dto);
    void deleteCategory(long id);
    Category getCategoryEntityById(Long id); 
}
