package com.test.pojo;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
public class User {
    private String id;

    private String username;

    private String password;

    private String phone;

    private Date createTime;

    private Date updateTime;

    private String img;

    public User(String id, String username, String password, String phone, Date createTime, Date updateTime, String img) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.img = img;
    }

    public User() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }
}