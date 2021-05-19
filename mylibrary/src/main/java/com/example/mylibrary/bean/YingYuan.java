package com.example.mylibrary.bean;

import java.io.Serializable;

public class YingYuan implements Serializable {

    /**
     * cinema_id : 1
     * cinema_name : 横店电影城(庆丰店)
     * cinema_phone : 13498476301
     * province : 广东
     * city : 广州
     * county : 白云区
     * specified_address : 白云区庆丰广场路财智广场2楼
     * score : 4
     * brand : 万达影城
     * feature : IMAX
     */

    private int cinema_id;
    private String cinema_name;
    private String cinema_phone;
    private String province;
    private String city;
    private String county;
    private String specified_address;
    private int score;
    private String brand;
    private String feature;

    public int getCinema_id() {
        return cinema_id;
    }

    public void setCinema_id(int cinema_id) {
        this.cinema_id = cinema_id;
    }

    public String getCinema_name() {
        return cinema_name;
    }

    public void setCinema_name(String cinema_name) {
        this.cinema_name = cinema_name;
    }

    public String getCinema_phone() {
        return cinema_phone;
    }

    public void setCinema_phone(String cinema_phone) {
        this.cinema_phone = cinema_phone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getSpecified_address() {
        return specified_address;
    }

    public void setSpecified_address(String specified_address) {
        this.specified_address = specified_address;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }
}
