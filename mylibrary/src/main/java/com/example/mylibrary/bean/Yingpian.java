package com.example.mylibrary.bean;

public class Yingpian {

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
