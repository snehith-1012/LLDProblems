package com.LLD.LLD.stackOverflow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StackOverFlowDemo {

    public static void main(String args[]) {

        StackOverFlow system = new StackOverFlow();

        // user creation
        User snehith = new User(1, "snehith", "snehith@gmail.com");
        User trinath = new User(2, "trinath", "trinath@gmail.com");
        User jayanth = new User(3, "jayanth", "jayanth@gmail.com");

        Question javaQuestion = system.createQuestion(snehith, "what is java", "java", Arrays.asList(new Tag("java"), new Tag("basic")));

        System.out.println("snehith's reputation is " + snehith.getReputation());

        system.vote(jayanth, 1, javaQuestion);
        system.vote(trinath, 1, javaQuestion);

        System.out.println(javaQuestion.getNumberOfVotes());
        System.out.println("snehith's reputation is " + snehith.getReputation());

        Answer javaAnswer1 = system.answerQuestion(javaQuestion, trinath, "java is object oriented programming language");

        System.out.println("trinath's reputation is " + trinath.getReputation());

        Answer javaAnswer2 = system.answerQuestion(javaQuestion, jayanth, "java is java");

        System.out.println("jayanth's reputation is " + jayanth.getReputation());

        system.vote(snehith, 1, javaAnswer1);

        system.vote(snehith, -1, javaAnswer2);

        System.out.println("snehith's reputation is " + snehith.getReputation());
        System.out.println("trinath's reputation is " + trinath.getReputation());
        System.out.println("jayanth's reputation is " + jayanth.getReputation());

        Question dsaQuestion = system.createQuestion(snehith, "what is hashmap", "hashmap", Arrays.asList(new Tag("java"), new Tag("dsa")));

        List<Question> questions = system.getQuestionsBasedOnTag(new Tag("java"));

        questions.stream().map(Question::getQuestionContent).forEach(System.out::println);

    }
}
