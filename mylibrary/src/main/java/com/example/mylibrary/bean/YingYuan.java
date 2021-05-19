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



//    <?xml version="1.0" encoding="utf-8"?>
//<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
//    xmlns:app="http://schemas.android.com/apk/res-auto"
//    xmlns:tools="http://schemas.android.com/tools"
//    android:layout_width="match_parent"
//    android:layout_height="match_parent"
//    tools:context=".goup.ChangCiXuanze">
//<LinearLayout
//    android:layout_width="match_parent"
//    android:layout_height="match_parent"
//    android:orientation="vertical">
//    <LinearLayout
//    android:layout_width="match_parent"
//    android:layout_height="50dp"
//    android:background="#3199FF">
//        <ImageView
//    android:id="@+id/xuanzechangc_fanh"
//    android:layout_width="50dp"
//    android:layout_height="50dp"
//    android:padding="8dp"
//    android:src="@drawable/fanh"/>
//        <TextView
//    android:layout_width="match_parent"
//    android:layout_height="match_parent"
//    android:text="选择场次"
//    android:textColor="#fff"
//    android:textSize="22sp"
//    android:gravity="center"
//    android:textStyle="bold"/>
//    </LinearLayout>
//    <TextView
//    android:id="@+id/xuanzechangc_name"
//    android:layout_width="match_parent"
//    android:layout_height="wrap_content"
//    android:text="casa"
//    android:textSize="18sp"
//    android:textColor="#000"
//    android:gravity="center"
//    android:padding="6dp"/>
//    <TextView
//    android:id="@+id/xuanzechangc_dizhi"
//    android:layout_width="match_parent"
//    android:layout_height="wrap_content"
//    android:text="casa"
//    android:textSize="16sp"
//    android:gravity="center"/>
//    <LinearLayout
//    android:layout_width="match_parent"
//    android:background="@drawable/shur_biank"
//    android:layout_margin="3dp"
//    android:padding="5dp"
//    android:layout_height="wrap_content">
//        <ImageView
//    android:id="@+id/xuanzechangc_dengm_tup"
//    android:layout_width="0dp"
//    android:layout_height="70dp"
//    android:scaleType="fitXY"
//    android:layout_weight="1"/>
//        <LinearLayout
//    android:layout_width="0dp"
//    android:layout_height="match_parent"
//    android:orientation="vertical"
//    android:layout_weight="2">
//            <TextView
//    android:id="@+id/xuanzechangc_dengm_name"
//    android:layout_width="match_parent"
//    android:layout_height="wrap_content"
//    android:text="name"
//    android:gravity="center"
//    android:textColor="#000"/>
//            <RatingBar
//    android:id="@+id/xuanzechangc_dengm_pingf"
//    android:layout_width="wrap_content"
//    android:layout_height="wrap_content"
//    android:isIndicator="true"
//    style="@style/Widget.AppCompat.RatingBar.Indicator"
//    android:layout_gravity="center"/>
//        </LinearLayout>
//    </LinearLayout>
//    <LinearLayout
//    android:layout_width="match_parent"
//    android:layout_height="wrap_content"
//    android:layout_margin="5dp"
//    android:padding="5dp"
//    android:background="@drawable/shur_biank"
//    android:orientation="vertical">
//        <LinearLayout
//    android:layout_width="match_parent"
//    android:layout_height="wrap_content">
//            <TextView
//    android:id="@+id/xuanzechangc_ls_kaistime"
//    android:layout_width="match_parent"
//    android:layout_weight="1"
//    android:layout_height="match_parent"/>
//            <TextView
//    android:id="@+id/xuanzechangc_ls_guangbtime"
//    android:layout_width="wrap_content"
//    android:layout_height="match_parent"/>
//        </LinearLayout>
//        <LinearLayout
//    android:layout_width="match_parent"
//    android:layout_height="wrap_content">
//            <TextView
//    android:id="@+id/xuanzechangc_ls_yingpleix"
//    android:layout_width="0dp"
//    android:layout_weight="1"
//    android:layout_height="match_parent"/>
//            <TextView
//    android:id="@+id/xuanzechangc_ls_bofangleix"
//    android:layout_width="0dp"
//    android:layout_weight="1"
//    android:layout_height="match_parent"/>
//            <TextView
//    android:id="@+id/xuanzechangc_ls_danjia"
//    android:layout_width="wrap_content"
//    android:text="单价"
//    android:layout_height="match_parent"/>
//        </LinearLayout>
//        <TextView
//    android:id="@+id/xuanzechangc_ls_goupiao"
//    android:layout_width="wrap_content"
//    android:layout_height="wrap_content"
//    android:text="购票"
//    android:layout_gravity="center"
//    android:textSize="18sp"
//    android:textColor="#fff"
//    android:layout_margin="5dp"
//    android:gravity="center"
//    android:background="@drawable/ann_biank"
//    android:padding="8dp"/>
//    </LinearLayout>
//</LinearLayout>
//</androidx.constraintlayout.widget.ConstraintLayout>
}
