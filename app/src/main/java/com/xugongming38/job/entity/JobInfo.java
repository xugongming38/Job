package com.xugongming38.job.entity;

import cn.bmob.v3.BmobObject;

/**
 * Created by dell on 2017/6/21.
 */

public class JobInfo extends BmobObject {

    private String name;
    private String content;
    private String title;
    private String phone;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
