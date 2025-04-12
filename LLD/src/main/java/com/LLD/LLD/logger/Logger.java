package com.LLD.LLD.logger;

import java.time.Instant;

public abstract class Logger {

    protected Logger nextLogger;

    public void printLog(String message, LoggerEnum type) {
        if (canHandle(type)) {
            System.out.println("log level is " + type.getLogLevel() + " time stamp is " + Instant.now());
            write(message);
        } else if (nextLogger != null) {
            System.out.println("Passed to next logger " + nextLogger);
            nextLogger.printLog(message, type);
        }
    }

    protected abstract void write(String message);

    protected abstract boolean canHandle(LoggerEnum type);
}
