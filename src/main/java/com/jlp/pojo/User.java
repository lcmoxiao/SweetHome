package com.jlp.pojo;

import java.util.Date;

public class User {
    private Integer userid;

    private String username;

    private String userpassword;

    private Date usercreatetime;

    private Date userbirth;

    private Byte usersex;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public Date getUsercreatetime() {
        return usercreatetime;
    }

    public void setUsercreatetime(Date usercreatetime) {
        this.usercreatetime = usercreatetime;
    }

    public Date getUserbirth() {
        return userbirth;
    }

    public void setUserbirth(Date userbirth) {
        this.userbirth = userbirth;
    }

    public Byte getUsersex() {
        return usersex;
    }

    public void setUsersex(Byte usersex) {
        this.usersex = usersex;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                ", usercreatetime=" + usercreatetime +
                ", userbirth=" + userbirth +
                ", usersex=" + usersex +
                '}';
    }
}