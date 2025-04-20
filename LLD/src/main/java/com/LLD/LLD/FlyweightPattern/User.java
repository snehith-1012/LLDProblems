package com.LLD.LLD.FlyweightPattern;

public class User {

    private int userId;

    private UserImage userImage;

    public User(int userId, UserImage userImage) {
        this.userId = userId;
        this.userImage = userImage;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public UserImage getUserImage() {
        return userImage;
    }

    public void setUserImage(UserImage userImage) {
        this.userImage = userImage;
    }
}
