package com.LLD.LLD.stackOverflow;


import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Question implements Commentable, Votable {

    int questionId;

    private String questionContent;

    private List<Answer> answers;

    private List<Comment> comments;

    private List<Tag> tags;

    private List<Vote> votes;

    private String title;

    private Date creationDate;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public void addComment(Comment comment) {
        this.addComment(comment);
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public void addAnswer(Answer answer) {
        this.answers.add(answer);
    }

    public Question(User user, int questionId, String questionContent, String title, List<Tag> tags) {
        this.user = user;
        this.questionId = questionId;
        this.questionContent = questionContent;
        this.title = title;
        this.tags = tags;
        this.creationDate = new Date();
        this.votes = new ArrayList<>();
        this.answers = new ArrayList<>();
    }

    @Override
    public void addVote(Vote vote) {
        if (!CollectionUtils.isEmpty(this.votes)) {
            this.votes.removeIf(vote1 -> vote1.getVotedByUser().equals(vote.getVotedByUser()));
        }
        this.votes.add(vote);
        this.user.updateReputation(vote.getValue() * 5);
    }

    @Override
    public int getNumberOfVotes() {
        return this.votes.stream().mapToInt(vote -> vote.getValue()).sum();
    }
}
