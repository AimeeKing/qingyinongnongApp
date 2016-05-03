package com.example.hdu.qingyinongnong.model;

import java.util.Date;

/**
 * Created by Aimee on 2016/4/16.
 */
public class cookbook {
    private String img;
    private int view_num;
    private int love_num;
    private Date pub_time;
    private String content;//菜谱中的内容用web来实现
    private int cookbook_id;

    public String getContent() {
        return content;
    }

    public int getCookbook_id() {
        return cookbook_id;
    }

    public String getImg() {
        return img;
    }

    public int getLove_num() {
        return love_num;
    }

    public Date getPub_time() {
        return pub_time;
    }

    public int getView_num() {
        return view_num;
    }


    public void setContent(String content) {
        this.content = content;
    }

    public void setCookbook_id(int cookbook_id) {
        this.cookbook_id = cookbook_id;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setLove_num(int love_num) {
        this.love_num = love_num;
    }

    public void setPub_time(Date pub_time) {
        this.pub_time = pub_time;
    }

    public void setView_num(int view_num) {
        this.view_num = view_num;
    }
}
