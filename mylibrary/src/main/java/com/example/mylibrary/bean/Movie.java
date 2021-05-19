package com.example.mylibrary.bean;

import java.io.Serializable;

public class Movie implements Serializable {

    /**
     * movie_id : 3
     * name : 夏目友人帐
     * poster : /images/movie/hot3.jpg
     * director : 大森贵弘
     * actor : 村濑步
     * movie_long : 105分钟
     * language : 日语
     * intro : 夏目（神谷浩史 配音）在一次归还妖怪名字的过程中，结识了外祖母玲子（小林沙苗 配音）的旧识津村容莉枝岛本须美 配音）和她的儿子椋雄（高良健吾 配音）。在与其接触后，夏目的“保镖”猫咪老师（井上和彦 配音）竟第一次意外分裂成了三只！夏目能否解决危机？这对母子又与妖怪有何关系？
     * type : 言情
     * public_date : 2018-11-13
     * wish_num : 1
     * score : 0
     * status : 1
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
    private float score;
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

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
