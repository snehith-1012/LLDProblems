package com.LLD.LLD.stackOverflow;

import java.util.List;

public interface Commentable {

    void addComment(Comment comment);

    List<Comment> getComments();
}
