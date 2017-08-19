package com.test.pojo;

import java.util.Date;

public class WaterCard {
    private String id;

    private String code;

    private String password;

    private Integer type;

    private Integer status;

    private Float balance;

    private String remark;

    private String phone;

    private Integer def;

    private String watermeterCode;

    private Date ctime;

    private String userId;

    public WaterCard(String id, String code, String password, Integer type, Integer status, Float balance, String remark, String phone, Integer def, String watermeterCode, Date ctime, String userId) {
        this.id = id;
        this.code = code;
        this.password = password;
        this.type = type;
        this.status = status;
        this.balance = balance;
        this.remark = remark;
        this.phone = phone;
        this.def = def;
        this.watermeterCode = watermeterCode;
        this.ctime = ctime;
        this.userId = userId;
    }

    public WaterCard() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getDef() {
        return def;
    }

    public void setDef(Integer def) {
        this.def = def;
    }

    public String getWatermeterCode() {
        return watermeterCode;
    }

    public void setWatermeterCode(String watermeterCode) {
        this.watermeterCode = watermeterCode == null ? null : watermeterCode.trim();
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}