package com.brunorfreitas.rethink3_0.Data.Model;

public class Fare {

    private String uid;
    private Integer money;
    private Integer miles;
    private Double loadFactor;
    private Integer baseMiles;
    private String type;

    public Fare() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getMiles() {
        return miles;
    }

    public void setMiles(Integer miles) {
        this.miles = miles;
    }

    public Double getLoadFactor() {
        return loadFactor;
    }

    public void setLoadFactor(Double loadFactor) {
        this.loadFactor = loadFactor;
    }

    public Integer getBaseMiles() {
        return baseMiles;
    }

    public void setBaseMiles(Integer baseMiles) {
        this.baseMiles = baseMiles;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
