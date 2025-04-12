package com.LLD.LLD.logger;

import com.LLD.LLD.logger.Loggers.*;

public class LoggerService {

    private static LoggerService instance = null;
    private Logger fatalLogger;
    private Logger errorLogger;
    private Logger warningLogger;
    private Logger infoLogger;
    private Logger debugLogger;

    public static LoggerService getInstance() {
        if (instance == null) {
            return instance = new LoggerService();
        }
        return instance;
    }

    private LoggerService() {
        fatalLogger = new FatalLogger(null);
        errorLogger = new ErrorLogger(fatalLogger);
        warningLogger = new WarningLogger(errorLogger);
        infoLogger = new InfoLogger(warningLogger);
        debugLogger = new DebugLogger(infoLogger);
    }

    public void process(String message, LoggerEnum type, String writer) {
        LogWriter logWriter = LogWriterFactory.getLogWriter(writer);
        debugLogger.printLog(message, type);
        logWriter.push(message);
    }

}
