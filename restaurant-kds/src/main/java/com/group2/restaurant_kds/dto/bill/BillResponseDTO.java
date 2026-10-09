package com.group2.restaurant_kds.dto.bill;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BillResponseDTO {
    private Long id;
    private Long orderId;
    private BigDecimal totalAmount;
    private BigDecimal discount;
    private String paymentMethod;
    private LocalDateTime paidAt;

    public BillResponseDTO (){}
    public BillResponseDTO(Long id, Long orderId, BigDecimal totalAmount, BigDecimal discount, String paymentMethod,
            LocalDateTime paidAt) {
        this.id = id;
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.discount = discount;
        this.paymentMethod = paymentMethod;
        this.paidAt = paidAt;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
    public BigDecimal getDiscount() {
        return discount;
    }
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public LocalDateTime getPaidAt() {
        return paidAt;
    }
    public void setPaidAt(LocalDateTime paidAt) {
        this.paidAt = paidAt;
    }
}
