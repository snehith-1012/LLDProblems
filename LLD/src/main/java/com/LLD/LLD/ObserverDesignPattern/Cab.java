package com.LLD.LLD.ObserverDesignPattern;

import java.util.List;

public class Cab implements Observable{

    private int location;

    private List<Observer> observers;


    public Cab(int location, List<Observer> observers) {
        this.location = location;
        this.observers = observers;
    }

    public void addPassenger(Observer observer){
        observers.add(observer);
    }

    public void removePassenger(Observer observer){
        this.observers.remove(observer);
    }

    public void notifyPassengers(){
        for(Observer observer:observers){
            observer.updateLocation(this.location);
        }
    }

}
