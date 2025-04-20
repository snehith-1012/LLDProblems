package com.LLD.LLD.FlyweightPattern;

public class FlyWeightDemo {

    public static void main(String [] args){
        UserCreator userCreator = new UserCreator();
        User user1 = userCreator.getUser(1,"something");
        User user2 = userCreator.getUser(2,"something");
    }
}
