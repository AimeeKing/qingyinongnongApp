package com.example.hdu.qingyinongnong.model;

/**
 * Created by Aimee on 2016/4/16.
 */
public class user_found {
    //这个类用来描述用户购买的众筹
    private int found_id;//id
    private int user_id;
    private int fund_id;

    public int getUser_id() {
        return user_id;
    }

    public int getFound_id() {
        return found_id;
    }

    public void setFound_id(int found_id) {
        this.found_id = found_id;
    }

    public int getFund_id() {
        return fund_id;
    }

    public void setFund_id(int fund_id) {
        this.fund_id = fund_id;
    }



    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
