package com.codejames.middleware.model.entity;

import org.springframework.stereotype.Component;
import sun.dc.pr.PRError;

import java.math.BigDecimal;
import java.util.Date;

@Component
public class RedDetail {
    private Integer id;
    private Integer userId;
    private String redPacket; //全局唯一标识
    private Integer total;
    private BigDecimal amount;
    private Byte is_active;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRedPacket() {
        return redPacket;
    }

    public void setRedPacket(String redPacket) {
        this.redPacket = redPacket;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Byte getIs_active() {
        return is_active;
    }

    public void setIs_active(Byte is_active) {
        this.is_active = is_active;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
