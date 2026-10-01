package com.group2.restaurant_kds.dto.orderItem;


public class OrderItemRequestDTO {
    private String foodId;
    private Integer quantity;
    public String getFoodId() {
        return foodId;
    }
    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
