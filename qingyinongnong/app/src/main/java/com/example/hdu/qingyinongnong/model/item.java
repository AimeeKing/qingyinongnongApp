package com.example.hdu.qingyinongnong.model;

import java.util.ArrayList;

/**
 * Created by Aimee on 2016/4/16.
 */
public class item {
    //具体内容
    private ArrayList<String> imgs;//最多四张图片
    private int item_id;
    private String content;//具体内容用webview来实现

    public String getContent() {
        return content;
    }

    public ArrayList<String> getImgs() {
        return imgs;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImgs(ArrayList<String> imgs) {
        this.imgs = imgs;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }
}
