package com.codejames.middleware.server.dto;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString
public class RedPacketDto {
    private Integer userId;
    @NonNull
    private Integer total;
    @NonNull
    private Integer amount;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
