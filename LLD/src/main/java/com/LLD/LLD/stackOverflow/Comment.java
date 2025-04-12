package com.LLD.LLD.stackOverflow;

import java.util.Date;

public class Comment {

    private int commentId;

    private String commentContent;

    private User user;

    private Date date;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Comment( User user, String commentContent){
        this.commentId = (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
        this.user = user;
        this.commentContent = commentContent;
        this.date = new Date();
    }
}
