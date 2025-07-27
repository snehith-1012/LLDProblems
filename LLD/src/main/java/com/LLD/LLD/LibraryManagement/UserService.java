package com.LLD.LLD.LibraryManagement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

    private Map<String, User> users;

    public UserService() {
        this.users = new HashMap<>();
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    public void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    public void notifyUser(List<String> userIds, Book book) {
        Notification notification = new Notification("book {} is now available", book.getBookName());
        userIds.forEach((userId) -> {
            System.out.println("Notification sent to " + users.get(userId).getName());
            users.get(userId).addNotification(notification);
        });

    }
}
