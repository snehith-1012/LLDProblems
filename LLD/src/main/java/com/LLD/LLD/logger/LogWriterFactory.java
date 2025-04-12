package com.LLD.LLD.logger;

import com.LLD.LLD.logger.LogWriters.ConsoleWriter;
import com.LLD.LLD.logger.LogWriters.DBWriter;
import com.LLD.LLD.logger.LogWriters.FileWriter;

public class LogWriterFactory {

    public static LogWriter getLogWriter(String type) {
        switch (type) {
            case "DB":
                return new DBWriter();
            case "file":
                return new FileWriter();
            default:
                return new ConsoleWriter();
        }
    }
}
