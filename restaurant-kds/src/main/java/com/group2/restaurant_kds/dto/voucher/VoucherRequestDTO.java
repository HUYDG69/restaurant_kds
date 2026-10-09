package com.group2.restaurant_kds.dto.voucher;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class VoucherRequestDTO {
    private String code;
    private String name;
    private String description;
    private String discountType;
    private BigDecimal discountValue;
    private BigDecimal minOrderAmount;
    private BigDecimal maxDiscountAmount;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private Integer usageLimit;
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDiscountType() {
        return discountType;
    }
    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }
    public BigDecimal getDiscountValue() {
        return discountValue;
    }
    public void setDiscountValue(BigDecimal discountValue) {
        this.discountValue = discountValue;
    }
    public BigDecimal getMinOrderAmount() {
        return minOrderAmount;
    }
    public void setMinOrderAmount(BigDecimal minOrderAmount) {
        this.minOrderAmount = minOrderAmount;
    }
    public BigDecimal getMaxDiscountAmount() {
        return maxDiscountAmount;
    }
    public void setMaxDiscountAmount(BigDecimal maxDiscountAmount) {
        this.maxDiscountAmount = maxDiscountAmount;
    }
    public LocalDateTime getStartAt() {
        return startAt;
    }
    public void setStartAt(LocalDateTime startAt) {
        this.startAt = startAt;
    }
    public LocalDateTime getEndAt() {
        return endAt;
    }
    public void setEndAt(LocalDateTime endAt) {
        this.endAt = endAt;
    }
    public Integer getUsageLimit() {
        return usageLimit;
    }
    public void setUsageLimit(Integer usageLimit) {
        this.usageLimit = usageLimit;
    }
    
}
