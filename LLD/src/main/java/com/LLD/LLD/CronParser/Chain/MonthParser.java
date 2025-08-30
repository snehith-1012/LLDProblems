package com.LLD.LLD.CronParser.Chain;

import com.LLD.LLD.CronParser.Exceptions.InvalidCronExpression;
import com.LLD.LLD.CronParser.ParsingStratergy.ParsingStratergiesFactory;
import com.LLD.LLD.CronParser.ParsingStratergy.ParsingStratergy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.LLD.LLD.CronParser.Constants.TimeMeasurmentConstants.MONTH;

public class MonthParser extends CronChainHandler {
    private final String parserName = MONTH;

    public String getParserName() {
        return MONTH;
    }

    public static List<Integer> allMonths = new ArrayList<>();

    static {
        for (int i = 1; i <= 12; i++) {
            allMonths.add(i);
        }
    }

    @Override
    public List<Integer> getAllValues() {
        return allMonths;
    }

    @Override
    public void Handle(String[] arr, int index, Map<String, List<Integer>> result) {
        String stringToBeParsed = arr[index];
        ParsingStratergy parsingStratergy = ParsingStratergiesFactory.getParsingStratergy(stringToBeParsed);
        parsingStratergy.parse(stringToBeParsed, this, result);
        this.nextHandler.Handle(arr, index + 1, result);
    }

    @Override
    public boolean isInputWithInConstraints(String value) {
        try {
            return Integer.parseInt(value) >= 1 && Integer.parseInt(value) <= 12;
        } catch (NumberFormatException e) {
            throw new InvalidCronExpression(e.getMessage());
        }
    }
}
