package com.group2.restaurant_kds.entity;

import java.math.BigDecimal;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table (name = "order_items")
public class OrderItem {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne 
    @JoinColumn (name = "order_id")
    private Order order;
    @ManyToOne 
    @JoinColumn (name = "foods_id")
    private Food food;
    private String foodsName;
    @Enumerated(EnumType.STRING)
    private OrderItemStatus status = OrderItemStatus.PENDING; // Mặc định khi gọi món là PENDING
    private BigDecimal unitPrice;
    private Integer quantity;
    private BigDecimal lineTotal;
    public OrderItem(Long id, Order order, Food food, String foodsName, BigDecimal unitPrice, Integer quantity,
            BigDecimal lineTotal) {
        this.id = id;
        this.order = order;
        this.food = food;
        this.foodsName = foodsName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.lineTotal = lineTotal;
    }
    public  OrderItem(){}
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
    public Food getFood() {
        return food;
    }
    public void setFood(Food food) {
        this.food = food;
    }
    public String getFoodsName() {
        return foodsName;
    }
    public void setFoodsName(String foodsName) {
        this.foodsName = foodsName;
    }
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public BigDecimal getLineTotal() {
        return lineTotal;
    }
    public void setLineTotal(BigDecimal lineTotal) {
        this.lineTotal = lineTotal;
    }

    public OrderItemStatus getStatus() {
        return status;
    }
    public void setStatus(OrderItemStatus status) {
        this.status = status;
    }

    public enum OrderItemStatus {
    PENDING,    // Mới gọi, chờ bếp xác nhận
    COOKING,    // Bếp đang nấu
    DONE,       // Nấu xong, chờ phục vụ mang ra
    DELIVERED,  // Đã mang ra bàn cho khách
    CANCELLED   // Khách hủy món / Hết nguyên liệu
}
}
