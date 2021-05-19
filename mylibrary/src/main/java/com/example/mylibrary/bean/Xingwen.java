package com.example.mylibrary.bean;

public class Xingwen {

    /**
     * searchValue : null
     * createBy : null
     * createTime : 2020-10-12 16:06:58
     * updateBy : null
     * updateTime : 2020-10-12 16:07:01
     * remark : null
     * params : {}
     * id : 5
     * title : 外交部：将妥善安排驻休斯敦总领馆人员
     * content : 汪文斌：关于中国驻休斯敦总领馆馆员的有关情况，相信你已经从媒体上看到了。我这里要说的是，对于中国驻休斯敦总领馆的人员，中方将会作出妥善的安排。
     * imgUrl : /profile/xwen3.jpg
     * pressCategory : 时政
     * isRecommend : 0
     * likeNumber : 258
     * viewsNumber : 300
     * userId : 1
     * pressStatus : 0
     */

    private Object searchValue;
    private Object createBy;
    private String createTime;
    private Object updateBy;
    private String updateTime;
    private Object remark;
    private ParamsBean params;
    private int id;
    private String title;
    private String content;
    private String imgUrl;
    private String pressCategory;
    private int isRecommend;
    private int likeNumber;
    private int viewsNumber;
    private int userId;
    private int pressStatus;

    public Object getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(Object searchValue) {
        this.searchValue = searchValue;
    }

    public Object getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Object createBy) {
        this.createBy = createBy;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Object getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Object updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Object getRemark() {
        return remark;
    }

    public void setRemark(Object remark) {
        this.remark = remark;
    }

    public ParamsBean getParams() {
        return params;
    }

    public void setParams(ParamsBean params) {
        this.params = params;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getPressCategory() {
        return pressCategory;
    }

    public void setPressCategory(String pressCategory) {
        this.pressCategory = pressCategory;
    }

    public int getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(int isRecommend) {
        this.isRecommend = isRecommend;
    }

    public int getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(int likeNumber) {
        this.likeNumber = likeNumber;
    }

    public int getViewsNumber() {
        return viewsNumber;
    }

    public void setViewsNumber(int viewsNumber) {
        this.viewsNumber = viewsNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPressStatus() {
        return pressStatus;
    }

    public void setPressStatus(int pressStatus) {
        this.pressStatus = pressStatus;
    }

    public static class ParamsBean {
    }
}
