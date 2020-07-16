package com.homeWork.moudle04.test04;


import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -33846811406021071L;
    private String useName;
    private String passWord;

    public User() {
    }

    public User(String useName, String passWord) {
        this.useName = useName;
        this.passWord = passWord;
    }

    public String getUseName() {
        return useName;
    }

    public void setUseName(String useName) {
        this.useName = useName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "User{" +
                "useName='" + useName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
