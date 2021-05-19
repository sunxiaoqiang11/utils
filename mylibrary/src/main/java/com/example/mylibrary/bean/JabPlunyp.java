package com.example.mylibrary.bean;

public class JabPlunyp {
//    <?xml version="1.0" encoding="utf-8"?>
//<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
//    xmlns:app="http://schemas.android.com/apk/res-auto"
//    xmlns:tools="http://schemas.android.com/tools"
//    android:layout_width="match_parent"
//    android:layout_height="match_parent"
//    tools:context=".goup.DingzhiGoupiao">
//<LinearLayout
//    android:layout_width="match_parent"
//    android:layout_height="match_parent"
//    android:orientation="vertical">
//    <LinearLayout
//    android:layout_width="match_parent"
//    android:layout_height="50dp"
//    android:background="#3199FF">
//        <ImageView
//    android:id="@+id/xuanzeyingy_fanh"
//    android:layout_width="50dp"
//    android:layout_height="50dp"
//    android:padding="8dp"
//    android:src="@drawable/fanh"/>
//        <TextView
//    android:layout_width="match_parent"
//    android:layout_height="match_parent"
//    android:text="选择影院和场次"
//    android:textColor="#fff"
//    android:textSize="22sp"
//    android:gravity="center"
//    android:textStyle="bold"/>
//    </LinearLayout>
//    <RelativeLayout
//    android:layout_width="match_parent"
//    android:layout_height="130dp">
//        <ImageView
//    android:id="@+id/iv_movieImage"
//    android:layout_centerVertical="true"
//    android:layout_marginRight="10dp"
//    android:layout_marginLeft="10dp"
//    android:layout_width="120dp"
//    android:layout_height="100dp"/>
//        <TextView
//    android:id="@+id/tv_movieName"
//    android:text="颠覆历史交锋"
//    android:layout_toRightOf="@+id/iv_movieImage"
//    android:textSize="20sp"
//    android:textColor="#000"
//    android:padding="3dp"
//    android:maxLines="1"
//    android:ellipsize="end"
//    android:layout_width="wrap_content"
//    android:layout_height="wrap_content"/>
//        <TextView
//    android:id="@+id/tv_movieType"
//    android:text="颠覆历史交锋"
//    android:layout_toRightOf="@+id/iv_movieImage"
//    android:layout_below="@+id/tv_movieName"
//    android:textSize="18sp"
//    android:padding="3dp"
//    android:maxLines="1"
//    android:ellipsize="end"
//    android:layout_width="wrap_content"
//    android:layout_height="wrap_content"/>
//        <TextView
//    android:id="@+id/tv_playTime"
//    android:text="颠覆历史交锋"
//    android:layout_toRightOf="@+id/iv_movieImage"
//    android:layout_below="@+id/tv_movieType"
//    android:textSize="18sp"
//    android:padding="3dp"
//    android:maxLines="1"
//    android:ellipsize="end"
//    android:layout_width="wrap_content"
//    android:layout_height="wrap_content"/>
//        <TextView
//    android:id="@+id/tv_nei"
//    android:text="颠覆历史交锋"
//    android:layout_toRightOf="@+id/iv_movieImage"
//    android:layout_below="@+id/tv_playTime"
//    android:textSize="18sp"
//    android:padding="3dp"
//    android:maxLines="1"
//    android:ellipsize="end"
//    android:layout_width="wrap_content"
//    android:layout_height="wrap_content"/>
//    </RelativeLayout>
//
//    <androidx.recyclerview.widget.RecyclerView
//    android:id="@+id/xuanzeyingy_xuanzriq"
//    android:layout_width="match_parent"
//    android:layout_height="wrap_content" />
//
//    <ListView
//    android:id="@+id/xuanzeyingy_list"
//    android:layout_width="match_parent"
//    android:layout_height="match_parent"/>
//</LinearLayout>
//</androidx.constraintlayout.widget.ConstraintLayout>
    /**
     * id : 1
     * userId : admin
     * movieId : 1
     * score : 10
     * content : 啦啦啦啦
     * date : 2020-12-10T16:00:00.000Z
     * like : 5
     */

    private int id;
    private String userId;
    private int movieId;
    private int score;
    private String content;
    private String date;
    private int like;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
