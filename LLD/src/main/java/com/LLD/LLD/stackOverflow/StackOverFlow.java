package com.LLD.LLD.stackOverflow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StackOverFlow {
    Map<Integer, User> users;

    Map<Integer, Question> questions;

    Map<String, Tag> tags;

    Map<Integer, Answer> answers;

    Map<String,List<Question>> tagToQuestionsMap;

    public StackOverFlow() {
        users = new ConcurrentHashMap<>();
        questions = new ConcurrentHashMap<>();
        tags = new ConcurrentHashMap<>();
        answers = new ConcurrentHashMap<>();
        tagToQuestionsMap = new ConcurrentHashMap<>();
    }

    public User createUser(String email, String name) {
        User user = new User(users.size() + 1, email, name);
        users.put(users.size() + 1, user);
        return user;
    }

    public Question createQuestion(User user, String questionContent, String title, List<Tag> tags) {
        Question question = user.askQuestion(questionContent, questions.size() + 1, title, tags);
        questions.put(questions.size() + 1, question);
        for (Tag tag : tags) {
            this.tags.put(tag.getTagName(), tag);
            if (!tagToQuestionsMap.containsKey(tag.getTagName())) {
                tagToQuestionsMap.put(tag.getTagName(), new ArrayList<>());
            }
            tagToQuestionsMap.get(tag.getTagName()).add(question);
        }
        return question;
    }

    public Answer answerQuestion(Question question, User user, String answerContent) {
        Answer answer = user.answerQuestion(question, answerContent, answers.size() + 1);
        answers.put(answers.size() + 1, answer);
        return answer;
    }

    public Comment addComment(String commentContent, User user, Commentable commentable){
        return user.addComment(commentContent,commentable);
    }

    public void vote(User user, int value, Votable votable){
        votable.addVote(new Vote(user,value));
    }


    public int getVotes(Votable votable){
        return votable.getNumberOfVotes();
    }

    public List<Question> getQuestionsBasedOnTag(Tag tag){
        return tagToQuestionsMap.get(tag.getTagName());
    }
}
