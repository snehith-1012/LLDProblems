package com.LLD.LLD.CronParser.Exceptions;

public class InvalidCronExpression extends RuntimeException {
    public InvalidCronExpression(String message) {
        super("Invalid cron Expression" + message);
    }
}
