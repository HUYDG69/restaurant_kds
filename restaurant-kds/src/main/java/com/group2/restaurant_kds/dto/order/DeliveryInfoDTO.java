package com.group2.restaurant_kds.dto.order;

import java.math.BigDecimal;

public class DeliveryInfoDTO {
    private String receiverName;
    private String receiverPhone;
    private String shippingAddress;
    private BigDecimal shippingFee;

    public DeliveryInfoDTO() {}
    public DeliveryInfoDTO(String receiverName, String receiverPhone, String shippingAddress, BigDecimal shippingFee) {
        this.receiverName = receiverName;
        this.receiverPhone = receiverPhone;
        this.shippingAddress = shippingAddress;
        this.shippingFee = shippingFee;
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
    public BigDecimal getShippingFee() {
        return shippingFee;
    }
    public void setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
    }


}