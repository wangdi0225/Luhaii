package com.king.luhai.Product;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/8/30.
 */
public class Friendlist implements Serializable {
    private String username;//昵称
    private int headphoto;//头像
    private String content;//发布内容
    private String time;//发布时间
    private String images;//图片

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public int getHeadphoto() {
        return headphoto;
    }
    public void setHeadphoto(int headphoto) {
        this.headphoto = headphoto;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getImages() {
        return images;
    }
    public void setImages(String images) {
        this.images = images;
    }





}