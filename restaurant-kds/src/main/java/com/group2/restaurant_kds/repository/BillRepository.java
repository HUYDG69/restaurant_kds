package com.group2.restaurant_kds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group2.restaurant_kds.entity.Bill;

@Repository 
public interface BillRepository extends JpaRepository<Bill,Long>{}