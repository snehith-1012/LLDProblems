package com.LLD.LLD.ProducerConsumerProblem;

import ch.qos.logback.core.joran.conditional.ThenAction;

public class DemoClass {


    public static void main(String args[]) {
        SharedResource sharedResource = new SharedResource();
        Thread producer = new Thread(new Producer(sharedResource));
        Thread consumer = new Thread(new Consumer(sharedResource));

        producer.start();
        consumer.start();
    }

}
