package com.LLD.LLD.HotelManagement;

public class User {

    private String userId;

    private String name;

    private String email;

    private Integer walletBalance;

    private UserTypeEnum userType;

    public User(String userId, String name, String email, Integer walletBalance, UserTypeEnum userType) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.walletBalance = walletBalance;
        this.userType = userType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(Integer walletBalance) {
        this.walletBalance = walletBalance;
    }

    public UserTypeEnum getUserType() {
        return userType;
    }

    public void setUserType(UserTypeEnum userType) {
        this.userType = userType;
    }
}
