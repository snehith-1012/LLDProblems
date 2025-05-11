package com.LLD.LLD.Twitter;

import java.util.HashMap;
import java.util.Map;

public class User {

    private int userId;

    private Map<Integer, Tweet> tweets;

    private Map<Integer, User> followers;

    private Map<Integer, User> following;

    private Map<Integer, Interaction> interactions;

    public User(int userId) {
        this.userId = userId;
        this.tweets = new HashMap<>();
        this.followers = new HashMap<>();
        this.following = new HashMap<>();
        this.interactions = new HashMap<>();
    }

    public void addInteraction(Interaction interaction) {
        this.interactions.put(interaction.getInteractionId(), interaction);
    }

    public void removeInteraction(Interaction interaction) {
        this.interactions.remove(interaction.getInteractionId());
    }

    public void addNewFollower(User user) {
        this.followers.put(user.getUserId(), user);
    }

    public void removeFollower(User user) {
        this.followers.remove(user.getUserId());
    }
    public void addToFollowing(User user){
        this.following.put(user.getUserId(),user);
    }

    public void removeFromFollowing(int userId){
        this.following.remove(userId);
    }
    public void tweet(Tweet tweet) {
        this.tweets.put(tweet.getTweetId(), tweet);
    }

    public void removeTweet(int tweetId) {
        this.tweets.remove(tweetId);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Map<Integer, Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(Map<Integer, Tweet> tweets) {
        this.tweets = tweets;
    }

    public Map<Integer, User> getFollowers() {
        return followers;
    }

    public void setFollowers(Map<Integer, User> followers) {
        this.followers = followers;
    }

    public Map<Integer, User> getFollowing() {
        return following;
    }

    public void setFollowing(Map<Integer, User> following) {
        this.following = following;
    }

    public Map<Integer, Interaction> getInteractions() {
        return interactions;
    }

    public void setInteractions(Map<Integer, Interaction> interactions) {
        this.interactions = interactions;
    }
}
