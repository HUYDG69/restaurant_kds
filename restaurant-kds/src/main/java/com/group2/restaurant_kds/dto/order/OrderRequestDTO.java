package com.group2.restaurant_kds.dto.order;

import java.util.List;

import com.group2.restaurant_kds.dto.orderItem.OrderItemRequestDTO;

public class OrderRequestDTO {
    private Long tableId;
    private String orderType;  // tại chỗ hoặc giao 
    private String note;
    
    private List<OrderItemRequestDTO> items;

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<OrderItemRequestDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemRequestDTO> items) {
        this.items = items;
    } 
}
