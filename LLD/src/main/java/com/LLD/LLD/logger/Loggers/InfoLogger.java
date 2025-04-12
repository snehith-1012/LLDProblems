package com.LLD.LLD.logger.Loggers;

import com.LLD.LLD.logger.Logger;
import com.LLD.LLD.logger.LoggerEnum;

public class InfoLogger extends Logger {

    public InfoLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    @Override
    public void write(String message) {
        System.out.println(message);
    }

    @Override
    public boolean canHandle(LoggerEnum type) {
        return LoggerEnum.INFO == type;
    }
}
