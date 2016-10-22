package org.allen.springmvc.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class User {
    private Long id;

    private String name;

    @JSONField(serialize = false)
    private String sex = "Unknown";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
