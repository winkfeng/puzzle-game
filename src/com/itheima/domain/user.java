package com.itheima.domain;

public class user {
    private String userName;
    private String password;

    public user() {
    }

    public user(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    /**
     * 获取
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "user{userName = " + userName + ", password = " + password + "}";
    }
}
