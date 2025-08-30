package com.LLD.LLD.CronParser;

public class CronParserDemo {

    public static void main(String[] args) {
        CronParserService cronParserService = new CronParserService();
//        cronParserService.parseCronExpression("* * * * *");
        cronParserService.parseCronExpression("2-5/2 11-14/3 1,2,5,8,9,11-28/2 FEB-DEC MON-FRI");
        cronParserService.parseCronExpression("2-5/2 11-14/3 1,2,5,8,9,11-28/2 FEB-DEC 1-4");
        cronParserService.parseCronExpression("1-59/10 11,12,13,15,19,20-23/2 * JAN-JUN/2 MON-SUN/3");
    }
}
