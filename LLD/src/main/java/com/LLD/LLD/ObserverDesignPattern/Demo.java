package com.LLD.LLD.ObserverDesignPattern;

import java.util.ArrayList;

public class Demo {

    public static void main(String [] args) {
        Observable cab1 = new Cab(1, new ArrayList<>());

        Observer p1 = new Passenger();
        Observer p2 = new Passenger();

        cab1.addPassenger(p1);
        cab1.addPassenger(p2);

        cab1.notifyPassengers();

        cab1.removePassenger(p1);
        cab1.notifyPassengers();
    }

}
