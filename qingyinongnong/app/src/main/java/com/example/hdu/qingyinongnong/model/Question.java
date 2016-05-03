package com.example.hdu.qingyinongnong.model;

import java.util.Date;

/**
 * Created by Aimee on 2016/4/16.
 */
public class Question {
    private String img;
    private String title;
    private String describ;
    private int love_num;//收藏的数量
    private int talk_num;//讨论的数量
    private Date time;//发布时间
    private int user_id;
    private int question_id;

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public Question() {
    }

    public String getDescrib() {
        return describ;
    }

    public String getImg() {
        return img;
    }

    public int getTalk_num() {
        return talk_num;
    }

    public Date getTime() {
        return time;
    }

    public String getTitle() {
        return title;
    }

    public int getLove_num() {
        return love_num;
    }

    public void setDescrib(String describ) {
        this.describ = describ;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setLove_num(int love_num) {
        this.love_num = love_num;
    }

    public void setTalk_num(int talk_num) {
        this.talk_num = talk_num;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
