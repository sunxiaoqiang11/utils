package com.example.mylibrary.bean;

import java.io.Serializable;

public class Jabjijshangy implements Serializable {

    /**
     * movie_id : 1
     * name : 驯龙高手3
     * poster : /images/movie/hot1.jpg
     * director : 迪恩·德布洛斯
     * actor : 刘昊然
     * movie_long : 130分钟
     * language : 英语
     * intro : 统领伯克岛的酋长嗝嗝（刘昊然 配音），与阿丝翠德（亚美莉卡·费雷拉 配音）共同打造了一个奇妙而热闹的飞龙乌托邦。一只雌性光煞飞龙的意外出现，加上一个前所未有的威胁的到来，令嗝嗝和没牙仔不得不离开自己唯一的家园，前往他们本以为只存在于神话之中的隐秘之境。在发现自己真正的命运之后，飞龙与骑士将携手殊死奋战，保护他们所珍爱的一切。
     * type : 动漫
     * public_date : 2018-12-11
     * wish_num : 0
     * score : 8.1
     * status : 0
     */

    private int movie_id;
    private String name;
    private String poster;
    private String director;
    private String actor;
    private String movie_long;
    private String language;
    private String intro;
    private String type;
    private String public_date;
    private int wish_num;
    private double score;
    private int status;

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getMovie_long() {
        return movie_long;
    }

    public void setMovie_long(String movie_long) {
        this.movie_long = movie_long;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPublic_date() {
        return public_date;
    }

    public void setPublic_date(String public_date) {
        this.public_date = public_date;
    }

    public int getWish_num() {
        return wish_num;
    }

    public void setWish_num(int wish_num) {
        this.wish_num = wish_num;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
