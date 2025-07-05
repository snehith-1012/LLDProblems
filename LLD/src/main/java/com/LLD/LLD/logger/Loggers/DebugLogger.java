package com.LLD.LLD.logger.Loggers;

import com.LLD.LLD.logger.Logger;
import com.LLD.LLD.logger.LoggerEnum;

import java.util.AbstractMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DebugLogger extends Logger {

    public DebugLogger(Logger nextLogger){
        this.nextLogger = nextLogger;
    }

    @Override
    public void write(String message) {
        System.out.println(message);
    }

    @Override
    public boolean canHandle(LoggerEnum type) {
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
        return LoggerEnum.DEBUG == type;
    }
}
