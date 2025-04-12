package com.LLD.LLD.logger;

public class LoggerDemo {

    public static void main(String args[]){
        LoggerService loggerService = LoggerService.getInstance();


        loggerService.process("print warning log", LoggerEnum.WARN,"file");


    }
}
