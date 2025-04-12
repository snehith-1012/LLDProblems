package com.LLD.LLD.stackOverflow;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int userId;

    private String userName;

    private String email;

    private int reputation;

    private List<Question> questions;

    private List<Answer> answers;

    private List<Comment> comments;

    private int QUESTION_REPUTATION = 5;

    private int ANSWER_REPUTATION = 10;

    private int COMMENT_REPUTATION = 2;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public User(int userId, String userName, String email) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.reputation = 0;
        this.questions = new ArrayList<>();
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public Question askQuestion(String questionContent, int questionId, String title, List<Tag> tags) {
        Question question = new Question(this, questionId, questionContent, title, tags);
        this.questions.add(question);
        updateReputation(QUESTION_REPUTATION);
        return question;
    }

    public Answer answerQuestion(Question question, String answerContent, int answerId) {
        Answer answer = new Answer(this, question, answerContent, answerId);
        updateReputation(ANSWER_REPUTATION);
        question.addAnswer(answer);
        answers.add(answer);
        return answer;
    }

    public Comment addComment(String commentContent, Commentable commentable) {
        Comment comment = new Comment(this, commentContent);
        comments.add(comment);
        updateReputation(COMMENT_REPUTATION);
        commentable.addComment(comment);
        return comment;
    }

    public void updateReputation(int reputation) {
        this.reputation += reputation;
    }


}
