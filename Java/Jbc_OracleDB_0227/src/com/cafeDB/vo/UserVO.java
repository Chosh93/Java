package com.cafeDB.vo;

public class UserVO {
    private int userId;
    private String userName;
    private String userPhone;
    private int userMil;

    public UserVO(int userId, String userName, String userPhone, int userMil) {
        this.userId = userId;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userMil = userMil;
    }

    public int getUserMil() {
        return userMil;
    }

    public void setUserMil(int userMil) {
        this.userMil = userMil;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
