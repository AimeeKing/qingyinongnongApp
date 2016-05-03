package com.example.hdu.qingyinongnong.model;

/**
 * Created by Aimee on 2016/4/16.
 */
public class user_love {
    //用来描述用户的收藏
    private int user_id;
    private int love_id;
    private int item_id;
    private int item_type;//收藏的东西的类型，包括菜谱，和众筹项目

    public int getItem_id() {
        return item_id;
    }

    public int getItem_type() {
        return item_type;
    }

    public int getLove_id() {
        return love_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public void setItem_type(int item_type) {
        this.item_type = item_type;
    }

    public void setLove_id(int love_id) {
        this.love_id = love_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
