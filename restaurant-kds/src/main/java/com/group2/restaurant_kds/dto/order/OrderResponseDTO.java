package com.group2.restaurant_kds.dto.order;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.logging.Log;

import com.group2.restaurant_kds.dto.orderItem.OrderItemResponseDTO;


public class OrderResponseDTO {
    private Long id;
    private String orderCode;
    private Long userId;
    private Long tableId;
    private String orderType;
    private String status;
    private BigDecimal subtotal;
    private BigDecimal totalAmount;
    private String note;
    private List<OrderItemResponseDTO> items;
    private DeliveryInfoDTO deliveryInfo;
    private String voucherCode;
    private BigDecimal discountAmount;
    private String cancelReason;
    
    public OrderResponseDTO(Long id, String orderCode, Long userId, Long tableId, String orderType, String status,
            BigDecimal subtotal, BigDecimal totalAmount, String note, List<OrderItemResponseDTO> items,
            DeliveryInfoDTO deliveryInfo, String vouchercode, BigDecimal discountAmount, String cancelReason ) {
        this.id = id;
        this.orderCode = orderCode;
        this.userId = userId;
        this.tableId = tableId;
        this.orderType = orderType;
        this.status = status;
        this.subtotal = subtotal;
        this.totalAmount = totalAmount;
        this.note = note;
        this.items = items;
        this.deliveryInfo = deliveryInfo;
        this.voucherCode = vouchercode;
        this.discountAmount = discountAmount;
        this.cancelReason = cancelReason;
    }
    public  OrderResponseDTO(){}
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
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
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
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public List<OrderItemResponseDTO> getItems() {
        return items;
    }
    public void setItems(List<OrderItemResponseDTO> items) {
        this.items = items;
    }
    public DeliveryInfoDTO getDeliveryInfo() {
        return deliveryInfo;
    }
    public void setDeliveryInfo(DeliveryInfoDTO deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
    }
    public String getVoucherCode() {
        return voucherCode;
    }
    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }
    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }
    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }
    public String getCancelReason() {
        return cancelReason;
    }
    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }
}
