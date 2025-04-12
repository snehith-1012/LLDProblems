package com.LLD.LLD.logger.Loggers;

import com.LLD.LLD.logger.Logger;
import com.LLD.LLD.logger.LoggerEnum;

public class FatalLogger extends Logger {

    public FatalLogger(Logger nextLogger) {
        this.nextLogger = null;
    }

    @Override
    public void write(String message) {
        System.out.println(message);
    }

    @Override
    public boolean canHandle(LoggerEnum type) {
        return LoggerEnum.FATAL == type;
    }
}
