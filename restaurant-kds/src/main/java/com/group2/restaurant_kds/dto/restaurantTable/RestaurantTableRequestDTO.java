package com.group2.restaurant_kds.dto.restaurantTable;

public class RestaurantTableRequestDTO {
    private String tableName;
    private Integer capacity;
    public String getTableName() {
        return tableName;
    }
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    public Integer getCapacity() {
        return capacity;
    }
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    
}
