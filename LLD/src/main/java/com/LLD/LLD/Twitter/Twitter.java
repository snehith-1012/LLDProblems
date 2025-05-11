package com.LLD.LLD.Twitter;

import java.util.*;

public class Twitter {

    private Map<Integer, Tweet> tweets;

    // map of interaction, tweet

    // interactions count to map of tweetid,
    TreeMap<Integer, TreeMap<Integer, Tweet>> mostInteractedTweets;

    private Map<Integer, User> users;

    private static Twitter twitter;

    public static synchronized Twitter getInstance() {
        if (twitter == null) {
            return twitter = new Twitter();
        }
        return twitter;
    }


    private Twitter() {
        this.tweets = new LinkedHashMap<>();
        this.mostInteractedTweets = new TreeMap<>();
        this.users = new HashMap<>();
    }

    public void addUser(User user) {
        this.users.put(user.getUserId(), user);
    }

    public List<Tweet> getLatestTweets() {

        List<Map.Entry<Integer, Tweet>> lastFive = tweets.entrySet()
                .stream()
                .skip(Math.max(0, tweets.size() - 5)) // Skip all but the last 5
                .toList();

        List<Tweet> latestTweets = new ArrayList<>();

        for (Map.Entry<Integer, Tweet> tweet : lastFive) {
            latestTweets.add(tweets.get(tweet.getKey()));
        }
        return latestTweets;
    }

    public List<Tweet> getPopularTweets() {
        int limit = 5;
        List<Tweet> popularTweets = new ArrayList<>();
        Iterator<Map.Entry<Integer, TreeMap<Integer, Tweet>>> reverseIterator = mostInteractedTweets.descendingMap().entrySet().iterator();
        while (reverseIterator.hasNext()) {
            Map.Entry<Integer, TreeMap<Integer, Tweet>> outerEntry = reverseIterator.next();
            TreeMap<Integer, Tweet> tweets = outerEntry.getValue();
            for (Tweet tweet : tweets.values()) {
                limit--;
                popularTweets.add(tweet);
                if (limit == 0)
                    break;
            }
            if (limit == 0)
                break;
        }
        return popularTweets;
    }

    public void followUser(int user1, int user2) {
        users.get(user1).addNewFollower(users.get(user2));
        users.get(user2).addToFollowing(users.get(user1));
    }

    public void removeFollower(int user1, int user2) {
        users.get(user1).removeFollower(users.get(user2));
        users.get(user2).removeFromFollowing(user1);
    }

    public void tweet(int userId, Tweet tweet) {
        users.get(userId).tweet(tweet);
        tweets.put(tweet.getTweetId(), tweet);
        if (mostInteractedTweets.containsKey(tweet.getInteractionsCount())) {
            mostInteractedTweets.get(tweet.getInteractionsCount()).put(tweet.getTweetId(), tweet);
        } else {
            TreeMap<Integer, Tweet> mp = new TreeMap<>();
            mp.put(tweet.getTweetId(), tweet);
            mostInteractedTweets.put(tweet.getInteractionsCount(), mp);
        }
    }

    public void removeTweet(int userId, int tweetId) {
        users.get(userId).removeTweet(tweetId);
        mostInteractedTweets.get(tweets.get(tweetId).getInteractionsCount()).remove(tweetId);
        tweets.remove(tweetId);
    }

    public void likeTweet(int tweetId, int userId) {
        mostInteractedTweets.get(tweets.get(tweetId).getInteractionsCount()).remove(tweetId);
        tweets.get(tweetId).likeTweet(users.get(userId));
        if (mostInteractedTweets.containsKey(tweets.get(tweetId).getInteractionsCount())) {
            mostInteractedTweets.get(tweets.get(tweetId).getInteractionsCount()).put(tweetId, tweets.get(tweetId));
        } else {
            TreeMap<Integer, Tweet> mp = new TreeMap<>();
            mp.put(tweetId, tweets.get(tweetId));
            mostInteractedTweets.put(tweets.get(tweetId).getInteractionsCount(), mp);
        }
    }

    public void unLikeTweet(int tweetId, int userId) {
        if (tweets.get(tweetId).getLikesCount() > 0) {
            mostInteractedTweets.get(tweets.get(tweetId).getInteractionsCount()).remove(tweetId);
            tweets.get(tweetId).unlikeTweet(users.get(userId));
            mostInteractedTweets.get(tweets.get(tweetId).getInteractionsCount()).put(tweetId, tweets.get(tweetId));
        }
    }

    public int doComment(int tweetId, int userId, String description) {
        mostInteractedTweets.get(tweets.get(tweetId).getInteractionsCount()).remove(tweetId);
        int commentId = tweets.get(tweetId).doComment(users.get(userId), description);
        if (mostInteractedTweets.containsKey(tweets.get(tweetId).getInteractionsCount())) {
            mostInteractedTweets.get(tweets.get(tweetId).getInteractionsCount()).put(tweetId, tweets.get(tweetId));
        } else {
            TreeMap<Integer, Tweet> mp = new TreeMap<>();
            mp.put(tweetId, tweets.get(tweetId));
            mostInteractedTweets.put(tweets.get(tweetId).getInteractionsCount(), mp);
        }
        return commentId;
    }

    public void unComment(int tweetId, int commentId, int userId) {
        if (tweets.get(tweetId).getCommentsCount() > 0) {
            tweets.get(tweetId).unComment(users.get(userId), commentId);
            mostInteractedTweets.get(tweets.get(tweetId).getInteractionsCount()).remove(tweetId);
            mostInteractedTweets.get(tweets.get(tweetId).getInteractionsCount() - 1).put(tweetId, tweets.get(tweetId));
        }
    }


    public Map<Integer, Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(Map<Integer, Tweet> tweets) {
        this.tweets = tweets;
    }

    public TreeMap<Integer, TreeMap<Integer, Tweet>> getMostInteractedTweets() {
        return mostInteractedTweets;
    }

    public void setMostInteractedTweets(TreeMap<Integer, TreeMap<Integer, Tweet>> mostInteractedTweets) {
        this.mostInteractedTweets = mostInteractedTweets;
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public void setUsers(Map<Integer, User> users) {
        this.users = users;
    }
}
