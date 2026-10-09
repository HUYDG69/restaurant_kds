package com.group2.restaurant_kds.dto.restaurantTable;

public class RestaurantTableResponseDTO {
    private Long id;
    private String tableName;
    private Integer capacity;
    private Boolean status;
    public RestaurantTableResponseDTO(Long id, String tableName, Integer capacity, Boolean status) {
        this.id = id;
        this.tableName = tableName;
        this.capacity = capacity;
        this.status = status;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
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
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    
}
