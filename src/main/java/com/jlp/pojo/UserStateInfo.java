package com.jlp.pojo;

import java.io.Serializable;

enum UserState {
    ONLINE,
    OFFLINE,
    WEAK_ONLINE
}

public class UserStateInfo implements Serializable {

    Integer userid;
    UserState userState;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public UserState getUserState() {
        return userState;
    }

    public void setUserState(UserState userState) {
        this.userState = userState;
    }

    @Override
    public String toString() {
        return "UserStateInfo{" +
                "userid=" + userid +
                ", userState=" + userState +
                '}';
    }
}
