package com.example.hdu.qingyinongnong.model;

import java.util.Date;

/**
 * Created by Aimee on 2016/4/16.
 */
public class Crow_funding {
    //众筹类
    private String title;
    private int user_id;//发布者id
    private int have_sold;//已经出售
    private int status;//状态，0表示众筹中，1表示热卖中
    private float aim_fund;//目标资金
    private int people;//参与人数
    private float have_fund;//已经筹集的数量
    private Date public_time;
    private String img;//图片地址
    private String describ;//描述
    private int item_id;
    private int fund_id;//id

    public int getFund_id() {
        return fund_id;
    }

    public void setPublic_time(Date public_time) {
        this.public_time = public_time;
    }

    public void setFund_id(int fund_id) {
        this.fund_id = fund_id;
    }

    public Date getPublic_time() {
        return public_time;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public float getAim_fund() {
        return aim_fund;
    }

    public String getDescrib() {
        return describ;
    }

    public float getHave_fund() {
        return have_fund;
    }

    public int getHave_sold() {
        return have_sold;
    }

    public String getImg() {
        return img;
    }

    public int getPeople() {
        return people;
    }

    public int getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public void setAim_fund(float aim_fund) {
        this.aim_fund = aim_fund;
    }

    public void setDescrib(String describ) {
        this.describ = describ;
    }

    public void setHave_fund(float have_fund) {
        this.have_fund = have_fund;
    }

    public void setHave_sold(int have_sold) {
        this.have_sold = have_sold;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setPeople(int people) {
        this.people = people;
    }


    public void setStatus(int status) {
        this.status = status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUser_id(int writer) {
        user_id = writer;
    }
}
