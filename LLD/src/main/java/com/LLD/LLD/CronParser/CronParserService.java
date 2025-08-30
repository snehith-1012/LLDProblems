package com.LLD.LLD.CronParser;

import com.LLD.LLD.CronParser.Chain.*;
import com.LLD.LLD.CronParser.Exceptions.InvalidCronExpression;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.LLD.LLD.CronParser.Constants.cronExpressionConstants.QUESTION_MARK;



public class CronParserService {

//    private static Map<Integer, String> normalCronExpression = Map.of(
//            0, MINUTE,
//            1, HOUR,
//            2, DAY_OF_MONTH,
//            3, MONTH,
//            4, DAY_OF_WEEK
//    );
//
//    private static Map<Integer, String> quartzCronExpression = Map.of(
//            0, SECOND,
//            1, MINUTE,
//            2, HOUR,
//            3, DAY_OF_MONTH,
//            4, MONTH,
//            5, DAY_OF_WEEK,
//            6, YEAR
//    );

    private static SecondParser secondParser;
    private static SecondParser secondParser1;
    private static MinuteParser minuteParser;
    private static MinuteParser minuteParser1;
    private static HourParser hourParser;
    private static HourParser hourParser1;
    private static DayOfMonthParser dayOfMonthParser;
    private static DayOfMonthParser dayOfMonthParser1;
    private static MonthParser monthParser;
    private static MonthParser monthParser1;
    private static DayOfWeekParser dayOfWeekParser;
    private static DayOfWeekParser dayOfWeekParser1;
    private static YearParser yearParser;
    private static YearParser yearParser1;

    static {
        secondParser = new SecondParser();
        secondParser1 = new SecondParser();
        minuteParser = new MinuteParser();
        minuteParser1 = new MinuteParser();
        hourParser = new HourParser();
        hourParser1 = new HourParser();
        dayOfMonthParser = new DayOfMonthParser();
        dayOfMonthParser1 = new DayOfMonthParser();
        monthParser = new MonthParser();
        monthParser1 = new MonthParser();
        dayOfWeekParser = new DayOfWeekParser();
        dayOfWeekParser1 = new DayOfWeekParser();
        yearParser = new YearParser();
        yearParser1 = new YearParser();
    }

    public CronChainHandler getNormalCronExpressionChainHandler() {
        minuteParser.setNextHandler(hourParser);
        hourParser.setNextHandler(dayOfMonthParser);
        dayOfMonthParser.setNextHandler(monthParser);
        monthParser.setNextHandler(dayOfWeekParser);
        dayOfWeekParser.setNextHandler(null);
        return minuteParser;
    }

    public CronChainHandler getQuartzCronExpressionChainHandler() {
        secondParser1.setNextHandler(minuteParser1);
        minuteParser1.setNextHandler(hourParser1);
        hourParser1.setNextHandler(dayOfMonthParser1);
        dayOfMonthParser1.setNextHandler(monthParser1);
        monthParser1.setNextHandler(dayOfWeekParser1);
        dayOfWeekParser1.setNextHandler(yearParser1);
        yearParser1.setNextHandler(null);
        return secondParser1;
    }

    public Map<String, List<Integer>> parseCronExpression(String cronExpression) throws InvalidCronExpression {
        String[] arr = cronExpression.trim().split("\\s+");

        Map<String, List<Integer>> result = new HashMap<>();
        if (arr.length == 5) {
            getNormalCronExpressionChainHandler().Handle(arr, 0, result);
        } else if (arr.length == 7) {
            if (!Objects.equals(arr[3], QUESTION_MARK) && !Objects.equals(arr[5], QUESTION_MARK)) {
                throw new InvalidCronExpression("provided both day of week and day of month");
            }
            getQuartzCronExpressionChainHandler().Handle(arr, 0, result);
        } else {
            throw new InvalidCronExpression("invalid number of fields");
        }
        return result;
    }

}
