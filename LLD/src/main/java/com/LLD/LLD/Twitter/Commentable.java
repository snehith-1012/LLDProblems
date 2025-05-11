package com.LLD.LLD.Twitter;

public interface Commentable {

    public int doComment(User user, String description);

    public void unComment(User user, int commentId);
}
