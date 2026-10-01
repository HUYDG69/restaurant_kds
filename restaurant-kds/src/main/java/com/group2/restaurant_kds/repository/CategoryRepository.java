package com.group2.restaurant_kds.repository;

import com.group2.restaurant_kds.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  CategoryRepository  extends JpaRepository<Category, Long>{}
