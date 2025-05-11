package com.LLD.LLD.Twitter;

public class Comment implements Interaction {

    private int commentId;
    private String comment;

    public Comment(int commentId, String comment) {
        this.commentId = commentId;
        this.comment = comment;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public int getInteractionId() {
        return this.commentId;
    }
}
