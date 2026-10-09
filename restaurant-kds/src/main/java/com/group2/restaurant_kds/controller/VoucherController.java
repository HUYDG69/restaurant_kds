package com.group2.restaurant_kds.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group2.restaurant_kds.dto.voucher.VoucherRequestDTO;
import com.group2.restaurant_kds.dto.voucher.VoucherResponseDTO;
import com.group2.restaurant_kds.service.VoucherService;

@RestController 
@RequestMapping ("/api/vouchers")
public class VoucherController {
    private final VoucherService voucherService;
    public VoucherController (VoucherService voucherService){
        this.voucherService = voucherService;
    }

    @GetMapping 
    public List<VoucherResponseDTO> getAllVouchers(){
        return voucherService.getAllVouchers();
    }

    @GetMapping ("/{id}")
    public VoucherResponseDTO getVoucherById(@PathVariable Long id){
        return voucherService.getVoucherById(id);
    }

    @PostMapping 
    public VoucherResponseDTO createVoucher(@RequestBody VoucherRequestDTO dto){
        return voucherService.createVoucher(dto);
    }

    @PutMapping ("/{id}")
    public VoucherResponseDTO updateVoucher(@PathVariable Long id,@RequestBody VoucherRequestDTO dto){
        return voucherService.updateVoucher(id, dto);
    }

    @PatchMapping ("/{id}")
    public void disableVoucher(@PathVariable Long id){
        voucherService.disableVoucher(id);
    }
}
