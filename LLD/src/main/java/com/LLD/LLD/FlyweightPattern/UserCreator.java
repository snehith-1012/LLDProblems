package com.LLD.LLD.FlyweightPattern;

import java.util.HashMap;
import java.util.Map;

public class UserCreator {

    private static final Map<String, UserImage> userImageUrls = new HashMap<>();

    public User getUser(int userId, String imageUrl) {
        if (!userImageUrls.containsKey(imageUrl)) {
            userImageUrls.put(imageUrl, new UserImage(imageUrl));
        }
        return new User(userId, userImageUrls.get(imageUrl));
    }
}
