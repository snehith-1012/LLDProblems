package com.LLD.LLD.TrafficManagement;

import java.util.*;

public class TrafficManagement {

    private Queue<Thread> roads;

    private Map<Integer,Thread> roadToThreadMap;


    private static TrafficManagement trafficManagement = null;

    private Object lock = new Object();

    private TrafficManagement() {
        roads = new LinkedList<>();
        roadToThreadMap = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            Road road = new Road(i + 1, new Signal(LightTypeEnum.RED), new LinkedList<>());
            Thread th = new Thread(road);
            roadToThreadMap.put(road.getRoadId(),th);
            roads.add(th);
            th.start();
        }
    }

    public static TrafficManagement getInstance() {
        if (trafficManagement != null) {
            return trafficManagement = new TrafficManagement();
        }
        return trafficManagement;
    }

    public void addRoad(Road road) {
        this.roads.add(new Thread(road));
    }

    public void removeRoad(Road road) {
        this.roads.remove(new Thread(road));
    }

}
