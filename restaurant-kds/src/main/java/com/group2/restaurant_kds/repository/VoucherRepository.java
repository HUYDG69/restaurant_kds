package com.group2.restaurant_kds.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group2.restaurant_kds.entity.Voucher;

public interface  VoucherRepository extends  JpaRepository <Voucher,Long>{
    Optional<Voucher> findByCode (String code); 
}
