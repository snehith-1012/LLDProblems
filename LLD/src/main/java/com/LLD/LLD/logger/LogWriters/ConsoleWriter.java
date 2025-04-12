package com.LLD.LLD.logger.LogWriters;

import com.LLD.LLD.logger.LogWriter;

public class ConsoleWriter implements LogWriter {
    @Override
    public void push(String message) {
        System.out.println("writing into console");
    }
}
