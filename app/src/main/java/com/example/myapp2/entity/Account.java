package com.example.myapp2.entity;

public class Account {
    //收支id主键
    private Long id;
    //类别名称
    private String categoryName;
    //花费类型
    private Long costType;
    //金额
    private Double amt;
    //创建者名称
    private Long username;
    //备注信息
    private String info;
    //收支时间
    private String costTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getCostType() {
        return costType;
    }

    public void setCostType(Long costType) {
        this.costType = costType;
    }

    public Double getAmt() {
        return amt;
    }

    public void setAmt(Double amt) {
        this.amt = amt;
    }

    public Long getUsername() {
        return username;
    }

    public void setUsername(Long username) {
        this.username = username;
    }

    public String getCostTime() {
        return costTime;
    }

    public void setCostTime(String costTime) {
        this.costTime = costTime;
    }

}
