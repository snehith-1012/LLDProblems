package com.LLD.LLD.CronParser.Chain;

import com.LLD.LLD.CronParser.Exceptions.InvalidCronExpression;
import com.LLD.LLD.CronParser.ParsingStratergy.ParsingStratergiesFactory;
import com.LLD.LLD.CronParser.ParsingStratergy.ParsingStratergy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.LLD.LLD.CronParser.Constants.TimeMeasurmentConstants.SECOND;

public class SecondParser extends CronChainHandler {

    @Override
    public String getParserName() {
        return SECOND;
    }

    public static List<Integer> allSeconds = new ArrayList<>();

    static {
        for (int i = 0; i <= 59; i++) {
            allSeconds.add(i);
        }
    }

    @Override
    public List<Integer> getAllValues() {
        return allSeconds;
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
        } catch (Exception e) {
            throw new InvalidCronExpression("invalid seconds in the expression");
        }
    }
}
