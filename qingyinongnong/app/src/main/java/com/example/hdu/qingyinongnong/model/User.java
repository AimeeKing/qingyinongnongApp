package com.example.hdu.qingyinongnong.model;

/**
 * Created by Aimee on 2016/4/16.
 */
public class User {
    private String username;
    private String user_img;
    private String sign;//个性签名
    private String phone;
    private String email;
    private int province_id;
    private int city_id;
    private int user_id;

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getCity_id() {
        return city_id;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getProvince_id() {
        return province_id;
    }

    public String getSign() {
        return sign;
    }

    public String getUser_img() {
        return user_img;
    }

    public String getUsername() {
        return username;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setProvince_id(int province_id) {
        this.province_id = province_id;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public void setUser_img(String user_img) {
        this.user_img = user_img;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
