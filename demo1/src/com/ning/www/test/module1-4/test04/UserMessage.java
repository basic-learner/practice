package com.homeWork.moudle04.test04;

import java.io.Serializable;

public class UserMessage implements Serializable {
    private static final long serialVersionUID = -2903460168252059646L;
    private String s;
    private User user;

    public UserMessage() {
    }

    public UserMessage(String s, User user) {
        this.s = s;
        this.user = user;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserMessage{" +
                "s='" + s + '\'' +
                ", user=" + user +
                '}';
    }
}
