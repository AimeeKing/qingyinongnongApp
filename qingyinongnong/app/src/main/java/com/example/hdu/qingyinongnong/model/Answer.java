package com.example.hdu.qingyinongnong.model;

import java.util.Date;

/**
 * Created by Aimee on 2016/4/16.
 */
public class Answer {
    //回答
    private int user_id;
    private Date pub_time;
    private int question_id;//问题的id
    private String content;//回答的内容
    private int answer_id;

    public Answer() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getAnswer_id() {
        return answer_id;
    }

    public String getContent() {
        return content;
    }

    public Date getPub_time() {
        return pub_time;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setAnswer_id(int answer_id) {
        this.answer_id = answer_id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPub_time(Date pub_time) {
        this.pub_time = pub_time;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }


}
