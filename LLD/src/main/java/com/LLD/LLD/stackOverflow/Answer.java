package com.LLD.LLD.stackOverflow;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Answer implements Commentable, Votable {

    private int answerId;

    private String answerContent;

    private List<Vote> votes;

    private List<Comment> comments;

    private User author;
    private Question question;
    private boolean isAccepted;

    private Date creationDate;


    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
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


    public Answer(User user, Question question, String answerContent, int answerId) {
        this.question = question;
        this.author = user;
        this.answerContent = answerContent;
        this.answerId = answerId;
        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();
        this.creationDate = new Date();
    }

    @Override
    public void addVote(Vote vote) {
        if (!CollectionUtils.isEmpty(this.votes)) {
            this.votes.removeIf(vote1 -> vote1.getVotedByUser().equals(vote.getVotedByUser()));
        }
        this.votes.add(vote);
        this.author.updateReputation(vote.getValue() * 10);
    }

    @Override
    public int getNumberOfVotes() {
        return this.votes.stream().mapToInt(vote -> vote.getValue()).sum();
    }
}
