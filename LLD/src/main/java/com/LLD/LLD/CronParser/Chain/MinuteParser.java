package com.LLD.LLD.CronParser.Chain;

import com.LLD.LLD.CronParser.Exceptions.InvalidCronExpression;
import com.LLD.LLD.CronParser.ParsingStratergy.ParsingStratergiesFactory;
import com.LLD.LLD.CronParser.ParsingStratergy.ParsingStratergy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.LLD.LLD.CronParser.Constants.TimeMeasurmentConstants.MINUTE;

public class MinuteParser extends CronChainHandler {

    public String getParserName() {
        return MINUTE;
    }

    public static List<Integer> allMinutes = new ArrayList<>();

    static {
        for (int i = 0; i <= 59; i++) {
            allMinutes.add(i);
        }
    }

    @Override
    public List<Integer> getAllValues() {
        return allMinutes;
    }

    @Override
    public void Handle(String[] arr, int index, Map<String, List<Integer>> result) {
        String stringToBeParsed = arr[index];
        ParsingStratergy parsingStratergy = ParsingStratergiesFactory.getParsingStratergy(stringToBeParsed);
        parsingStratergy.parse(stringToBeParsed, this, result);
        this.nextHandler.Handle(arr, index+1, result);
    }

    @Override
    public boolean isInputWithInConstraints(String value) {
        try {
            return Integer.parseInt(value) >= 0 && Integer.parseInt(value) <= 59;
        } catch (NumberFormatException e) {
            throw new InvalidCronExpression(e.getMessage());
        }
    }
}
