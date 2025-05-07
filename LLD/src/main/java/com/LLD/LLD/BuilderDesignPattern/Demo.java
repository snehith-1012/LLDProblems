package com.LLD.LLD.BuilderDesignPattern;

public class Demo {

    public static void main(String[] args) {
        User user = new User.UserBuilder().id("123").build();

        User user1 = new User.UserBuilder().name("snehith").build();

        System.out.println("id is " + user.getId() + " and name is " + user.getName());
        System.out.println("id is " + user1.getId() + " and name is " + user1.getName());
    }
}
