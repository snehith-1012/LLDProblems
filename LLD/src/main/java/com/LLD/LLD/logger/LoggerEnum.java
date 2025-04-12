package com.LLD.LLD.logger;

public enum LoggerEnum {

    DEBUG("DEBUG", 1),
    INFO("INFO", 2),

    WARN("WARN", 3),
    ERROR("ERROR", 4),
    FATAL("FATAL", 5);

    private String value;

    private int logLevel;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(int logLevel) {
        this.logLevel = logLevel;
    }

    LoggerEnum(String value, int logLevel) {
        this.value = value;
        this.logLevel = logLevel;
    }
}
