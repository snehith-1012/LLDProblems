package com.LLD.LLD.ObserverDesignPattern;

public interface Observable {

    void notifyPassengers();

    void addPassenger(Observer observer);

    void removePassenger(Observer observer);
}
