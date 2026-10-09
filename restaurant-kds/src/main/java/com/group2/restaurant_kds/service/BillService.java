package com.group2.restaurant_kds.service;

import com.group2.restaurant_kds.dto.bill.BillRequestDTO;
import com.group2.restaurant_kds.dto.bill.BillResponseDTO;
import java.util.List;

public interface BillService {
    BillResponseDTO createBill(BillRequestDTO dto);
    BillResponseDTO getBillById(Long id);
    BillResponseDTO getBillByOrderId(Long orderId);
    List<BillResponseDTO> getAllBills();
}