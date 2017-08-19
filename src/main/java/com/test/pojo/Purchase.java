package com.test.pojo;

import java.util.Date;

public class Purchase {
    private String id;

    private String userId;

    private Float price;

    private Float totalPrice;

    private Float waterConsumption;

    private Float totalConsumption;

    private Float unitCost;

    private Float balance;

    private String name;

    private String place;

    private Date ctime;

    private String cardNo;

    private String collectorId;

    private String orderId;

    public Purchase(String id, String userId, Float price, Float totalPrice, Float waterConsumption, Float totalConsumption, Float unitCost, Float balance, String name, String place, Date ctime, String cardNo, String collectorId, String orderId) {
        this.id = id;
        this.userId = userId;
        this.price = price;
        this.totalPrice = totalPrice;
        this.waterConsumption = waterConsumption;
        this.totalConsumption = totalConsumption;
        this.unitCost = unitCost;
        this.balance = balance;
        this.name = name;
        this.place = place;
        this.ctime = ctime;
        this.cardNo = cardNo;
        this.collectorId = collectorId;
        this.orderId = orderId;
    }

    public Purchase() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public Float getWaterConsumption() {
        return waterConsumption;
    }

    public void setWaterConsumption(Float waterConsumption) {
        this.waterConsumption = waterConsumption;
    }

    public Float getTotalConsumption() {
        return totalConsumption;
    }

    public void setTotalConsumption(Float totalConsumption) {
        this.totalConsumption = totalConsumption;
    }

    public Float getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(Float unitCost) {
        this.unitCost = unitCost;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public String getCollectorId() {
        return collectorId;
    }

    public void setCollectorId(String collectorId) {
        this.collectorId = collectorId == null ? null : collectorId.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }
}