package com.LLD.LLD.Twitter;

import java.util.*;

public class Tweet implements Likable, Commentable {

    private int tweetId;

    private Date date;

    // userId to Interaction map
    private Map<Integer, Map<InteractionTypeEnum, Map<Integer, Interaction>>> interactions;

    private String tweetContent;

    private Random random = new Random();

    private int likesCount;

    private int commentsCount;

    public Tweet(int tweetId, String tweetContent) {
        this.tweetId = tweetId;
        this.date = new Date();
        this.interactions = new HashMap<>();
        this.tweetContent = tweetContent;
        this.likesCount = 0;
        this.commentsCount = 0;
    }

    @Override
    public int likeTweet(User user) {
        int likeId = random.nextInt();
        Like like = new Like(likeId, true);
        if (!interactions.containsKey(user.getUserId())) {
            Map<InteractionTypeEnum, Map<Integer, Interaction>> ints1 = new HashMap<>();
            Map<Integer, Interaction> ints2 = new HashMap<>();
            ints2.put(likeId, like);
            ints1.put(InteractionTypeEnum.LIKE, ints2);
            interactions.put(user.getUserId(), ints1);
        } else {
            if (interactions.get(user.getUserId()).containsKey(InteractionTypeEnum.LIKE)) {
                Map<Integer, Interaction> likes = interactions.get(user.getUserId()).get(InteractionTypeEnum.LIKE);
                likes.put(likeId, like);
            } else {
                Map<Integer, Interaction> likes = new HashMap<>();
                likes.put(likeId, like);
                interactions.get(user.getUserId()).put(InteractionTypeEnum.LIKE, likes);
            }
        }
        Map<Integer, Interaction> likes = interactions.get(user.getUserId()).get(InteractionTypeEnum.LIKE);
        user.addInteraction(likes.get(likeId));
        likesCount++;
        return likeId;
    }

    @Override
    public void unlikeTweet(User user) {
        Map<Integer, Interaction> likes = interactions.get(user.getUserId()).get(InteractionTypeEnum.LIKE);
        user.removeInteraction(likes.get(likes.keySet().stream().toList().get(0)));
        likesCount--;
        likes.clear();
    }

    @Override
    public int doComment(User user, String description) {
        int commentId = random.nextInt();
        Comment comment = new Comment(commentId, description);
        if (!interactions.containsKey(user.getUserId())) {
            Map<InteractionTypeEnum, Map<Integer, Interaction>> ints1 = new HashMap<>();
            Map<Integer, Interaction> ints2 = new HashMap<>();
            ints2.put(commentId, comment);
            ints1.put(InteractionTypeEnum.COMMENT, ints2);
            interactions.put(user.getUserId(), ints1);
        } else {
            if (interactions.get(user.getUserId()).containsKey(InteractionTypeEnum.COMMENT)) {
                Map<Integer, Interaction> comments = interactions.get(user.getUserId()).get(InteractionTypeEnum.COMMENT);
                comments.put(commentId, comment);
            } else {
                Map<Integer, Interaction> comments = new HashMap<>();
                comments.put(commentId, comment);
                interactions.get(user.getUserId()).put(InteractionTypeEnum.COMMENT, comments);
            }
        }
        Map<Integer, Interaction> comments = interactions.get(user.getUserId()).get(InteractionTypeEnum.COMMENT);
        user.addInteraction(comments.get(commentId));
        commentsCount++;
        return commentId;
    }

    @Override
    public void unComment(User user, int commentId) {
        Map<Integer, Interaction> comments = interactions.get(user.getUserId()).get(InteractionTypeEnum.COMMENT);
        user.removeInteraction(comments.get(commentId));
        commentsCount--;
        comments.remove(commentId);
    }

    public int getInteractionsCount() {
        return this.likesCount + this.commentsCount;
    }

    public int getTweetId() {
        return tweetId;
    }

    public void setTweetId(int tweetId) {
        this.tweetId = tweetId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTweetContent() {
        return tweetContent;
    }

    public void setTweetContent(String tweetContent) {
        this.tweetContent = tweetContent;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

}
