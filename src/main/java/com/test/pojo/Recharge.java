package com.test.pojo;

import java.util.Date;

public class Recharge {
    private String id;

    private String name;

    private String userId;

    private Float price;

    private Float totalPrice;

    private Float balance;

    private Date ctime;

    private String orderId;

    private String cardId;

    private Integer status;

    public Recharge(String id, String name, String userId, Float price, Float totalPrice, Float balance, Date ctime, String orderId, String cardId, Integer status) {
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.price = price;
        this.totalPrice = totalPrice;
        this.balance = balance;
        this.ctime = ctime;
        this.orderId = orderId;
        this.cardId = cardId;
        this.status = status;
    }

    public Recharge() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}