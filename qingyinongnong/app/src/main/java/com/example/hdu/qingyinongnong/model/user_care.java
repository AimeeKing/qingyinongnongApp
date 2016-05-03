package com.example.hdu.qingyinongnong.model;

/**
 * Created by Aimee on 2016/4/18.
 */
public class user_care {
    //这个类用来描述用户关注话题的关系
    private int care_id;//id
    private int user_id;
    private int topic_item;

    public int getCare_id() {
        return care_id;
    }

    public int getTopic_item() {
        return topic_item;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setCare_id(int care_id) {
        this.care_id = care_id;
    }

    public void setTopic_item(int topic_item) {
        this.topic_item = topic_item;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
