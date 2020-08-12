package com.example.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Table;
import java.util.Date;

@Table(name="user")
public class User {
    private String name;

    @JsonIgnore
    private String password;

    private Integer age;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a", locale = "ch", timezone = "GMT+8")
    private Date date;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", date=" + date +
                ", desc='" + desc + '\'' +
                '}';
    }

}
