package com.LLD.LLD.BookMyShow.Service;

import com.LLD.LLD.BookMyShow.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    private Map<String, User> users;

    public UserService() {
        this.users = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    public void removeUser(String userId) {
        users.remove(userId);
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    public void updateUser(User user) {
        User userToBeUpdated = users.get(user.getUserId());
        userToBeUpdated.setEmail(user.getEmail());
        userToBeUpdated.setName(user.getName());
        userToBeUpdated.setWalletBalance(user.getWalletBalance());
    }

}
