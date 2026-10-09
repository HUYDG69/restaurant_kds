package com.group2.restaurant_kds.service;

import com.group2.restaurant_kds.dto.bill.BillRequestDTO;
import com.group2.restaurant_kds.dto.bill.BillResponseDTO;
import com.group2.restaurant_kds.entity.Bill;
import com.group2.restaurant_kds.entity.Order;
import com.group2.restaurant_kds.repository.BillRepository;
import com.group2.restaurant_kds.repository.OrderRepository;
import com.group2.restaurant_kds.repository.RestaurantTableRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;
    private final OrderRepository orderRepository;
    private final RestaurantTableRepository tableRepository;

    public BillServiceImpl(BillRepository billRepository, OrderRepository orderRepository, RestaurantTableRepository tableRepository) {
        this.billRepository = billRepository;
        this.orderRepository = orderRepository;
        this.tableRepository = tableRepository;
    }

    @Override
    public BillResponseDTO createBill(BillRequestDTO dto) {
        Order order = orderRepository.findById(dto.getOrderId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy đơn hàng với ID: " + dto.getOrderId()));

        if ("COMPLETED".equals(order.getStatus())) {
            throw new RuntimeException("Đơn hàng này đã được thanh toán!");
        }

        // 1. Tạo và lưu Bill
        Bill bill = new Bill();
        bill.setOrder(order);
        bill.setPaymentMethod(dto.getPaymentMethod());
        
        // Lấy dữ liệu tự động từ Order để tránh Frontend truyền sai số tiền
        bill.setTotalAmount(order.getTotalAmount());
        
        // Đảm bảo discount không bị null
        BigDecimal discount = order.getDiscountAmount() != null ? order.getDiscountAmount() : BigDecimal.ZERO;
        bill.setDiscount(discount);

        Bill savedBill = billRepository.save(bill);

        
        // 2. Chốt đơn hàng (Chuyển sang COMPLETED)
        order.setStatus("COMPLETED");
        orderRepository.save(order);

        // 3. Giải phóng bàn (nếu đơn hàng có ngồi tại bàn)
        if (order.getTable() != null) {
            // Giả sử status = true nghĩa là bàn trống / sẵn sàng
            order.getTable().setStatus(true);
            tableRepository.save(order.getTable());
        }

        return mapToDTO(savedBill);
    }

    @Override
    public BillResponseDTO getBillById(Long id) {
        Bill bill = billRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy hóa đơn"));
        return mapToDTO(bill);
    }

    @Override
    public BillResponseDTO getBillByOrderId(Long orderId) {
        // Cần đảm bảo có hàm findByOrderId trong BillRepository của bạn
        Bill bill = billRepository.findByOrderId(orderId)
                .orElseThrow(() -> new RuntimeException("Chưa có hóa đơn cho đơn hàng này"));
        return mapToDTO(bill);
    }

    @Override
    public List<BillResponseDTO> getAllBills() {
        return billRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // ==========================================
    // HÀM MAPPING DTO 
    // ==========================================
    private BillResponseDTO mapToDTO(Bill bill) {
        BillResponseDTO dto = new BillResponseDTO();
        dto.setId(bill.getId());
        
        if (bill.getOrder() != null) {
            dto.setOrderId(bill.getOrder().getId());
        }
        
        dto.setTotalAmount(bill.getTotalAmount());
        dto.setDiscount(bill.getDiscount());
        dto.setPaymentMethod(bill.getPaymentMethod());
        dto.setPaidAt(bill.getPaidAt());
        
        return dto;
    }
}