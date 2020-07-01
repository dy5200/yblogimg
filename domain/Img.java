package com.thlly.domain;

import java.io.Serializable;
import java.util.Date;

public class Img implements Serializable {
    private Integer id;
    private String uploadUsername;
    private String imgUrl;
    private String userUpDate;

    @Override
    public String toString() {
        return "Img{" +
                "id=" + id +
                ", uploadUsername='" + uploadUsername + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", userUpDate='" + userUpDate + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUploadUsername() {
        return uploadUsername;
    }

    public void setUploadUsername(String uploadUsername) {
        this.uploadUsername = uploadUsername;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getUserUpDate() {
        return userUpDate;
    }

    public void setUserUpDate(String userUpDate) {
        this.userUpDate = userUpDate;
    }
}
