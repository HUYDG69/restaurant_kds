package com.group2.restaurant_kds.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity 
@Table (name = "bill")
public class Bill {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne 
    @JoinColumn(name = "order_id")
    private Order order;
    private BigDecimal totalAmount;
    private BigDecimal discount;
    private BigDecimal tax;
    private String paymentMethod;
    private LocalDateTime paidAt;
    public Bill(Long id, Order order, BigDecimal totalAmount, BigDecimal discount, BigDecimal tax, String paymentMethod,
            LocalDateTime paidAt) {
        this.id = id;
        this.order = order;
        this.totalAmount = totalAmount;
        this.discount = discount;
        this.tax = tax;
        this.paymentMethod = paymentMethod;
        this.paidAt = paidAt;
    }
    public Bill(){}
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
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
    public BigDecimal getTax() {    
        return tax;
    }
    public void setTax(BigDecimal tax) {
        this.tax = tax;
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
