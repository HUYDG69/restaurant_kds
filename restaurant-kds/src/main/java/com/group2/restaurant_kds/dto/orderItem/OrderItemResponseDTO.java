package com.group2.restaurant_kds.dto.orderItem;

import java.math.BigDecimal;

public class OrderItemResponseDTO {
    private Long id;
    private Long foodId;
    private Long orderId;
    private String foodName;
    private BigDecimal unitPrice;
    private Integer quantity;
    private BigDecimal lineTotal;
    private String status; 

    public OrderItemResponseDTO() {}
    public OrderItemResponseDTO(Long id, Long foodId, Long orderId, String foodName, BigDecimal unitPrice,
            Integer quantity, BigDecimal lineTotal, String status) {
        this.id = id;
        this.foodId = foodId;
        this.orderId = orderId;
        this.foodName = foodName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.lineTotal = lineTotal;
        this.status = status;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getFoodId() {
        return foodId;
    }
    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }
    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public String getFoodName() {
        return foodName;
    }
    public void setFoodName(String foodName) {
        this.foodName = foodName;
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
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
