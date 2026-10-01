package com.group2.restaurant_kds.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table (name = "orders")
public class Order {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderCode;
    @ManyToOne 
    @JoinColumn(name = "user_id")
    private User user;  
    @ManyToOne
    @JoinColumn(name = "table_id")
    private RestaurantTable table;
    private String orderType;
    private String status;
    private BigDecimal subtotal;
    private BigDecimal shippingFee;
    private BigDecimal totalAmount;
    private String receiverName;
    private String receiverPhone;
    private String shippingAddress;
    private String note;
    private LocalDateTime cancelledAt;
    @ManyToOne
    @JoinColumn(name = "confirmed_by")
    private User confirmedBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    public Order(Long id, String orderCode, User user, RestaurantTable table, String orderType, String status,
            BigDecimal subtotal, BigDecimal shippingFee, BigDecimal totalAmount, String receiverName,
            String receiverPhone, String shippingAddress, String note, LocalDateTime cancelledAt, User confirmedBy,
            LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.orderCode = orderCode;
        this.user = user;
        this.table = table;
        this.orderType = orderType;
        this.status = status;
        this.subtotal = subtotal;
        this.shippingFee = shippingFee;
        this.totalAmount = totalAmount;
        this.receiverName = receiverName;
        this.receiverPhone = receiverPhone;
        this.shippingAddress = shippingAddress;
        this.note = note;
        this.cancelledAt = cancelledAt;
        this.confirmedBy = confirmedBy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public Order(){}
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getOrderCode() {
        return orderCode;
    }
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public RestaurantTable getTable() {
        return table;
    }
    public void setTable(RestaurantTable table) {
        this.table = table;
    }
    public String getOrderType() {
        return orderType;
    }
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public BigDecimal getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
    public BigDecimal getShippingFee() {
        return shippingFee;
    }
    public void setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
    }
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
    public String getReceiverName() {
        return receiverName;
    }
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }
    public String getReceiverPhone() {
        return receiverPhone;
    }
    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }
    public String getShippingAddress() {
        return shippingAddress;
    }
    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public LocalDateTime getCancelledAt() {
        return cancelledAt;
    }
    public void setCancelledAt(LocalDateTime cancelledAt) {
        this.cancelledAt = cancelledAt;
    }
    public User getConfirmedBy() {
        return confirmedBy;
    }
    public void setConfirmedBy(User confirmedBy) {
        this.confirmedBy = confirmedBy;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
}
