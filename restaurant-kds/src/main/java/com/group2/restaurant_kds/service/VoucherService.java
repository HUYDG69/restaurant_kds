package com.group2.restaurant_kds.service;

import java.math.BigDecimal;
import java.util.List;

import com.group2.restaurant_kds.dto.voucher.VoucherRequestDTO;
import com.group2.restaurant_kds.dto.voucher.VoucherResponseDTO;

public interface  VoucherService {
    VoucherResponseDTO createVoucher(VoucherRequestDTO dto);
    
    List<VoucherResponseDTO> getAllVouchers();
    
    VoucherResponseDTO getVoucherById(Long id);
    
    VoucherResponseDTO updateVoucher(Long id, VoucherRequestDTO dto);
    // Đổi trạng thái isActive thành false thay vì xóa hẳn khỏi database
    void disableVoucher(Long id);

    // Tính toán số tiền được giảm dựa trên mã code và tổng tiền hóa đơn hiện tại
    BigDecimal calculateDiscount(String code, BigDecimal currentOrderTotal);
    
    // Tăng số lượt đã sử dụng (usedCount) lên 1 sau khi đơn hàng thanh toán thành công
    void incrementUsageCount(String code);
}
