package com.LLD.LLD.CronParser.ParsingStratergy;

import com.LLD.LLD.CronParser.Chain.CronChainHandler;
import com.LLD.LLD.CronParser.Exceptions.InvalidCronExpression;
import com.LLD.LLD.CronParser.Utils.ExpressionDetermineUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.LLD.LLD.CronParser.Constants.TimeMeasurmentConstants.*;

public class ListParsingStratergy implements ParsingStratergy {

    @Override
    public void parse(String partialString, CronChainHandler handler, Map<String, List<Integer>> result) {
        String[] arr = partialString.split(",");
        List<Integer> vals = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].trim();
            if (ExpressionDetermineUtils.isRangeOrStepExpression(arr[i])) {
                ParsingStratergy parsingStratergy = ParsingStratergiesFactory.getParsingStratergy(arr[i]);
                parsingStratergy.parse(arr[i], handler, result);
            } else if (handler.isInputWithInConstraints(arr[i])) {
                if (MONTH.equals(handler.getParserName())) {
                    vals.add(ExpressionDetermineUtils.months.indexOf(arr[i]) + 1);
                } else if (DAY_OF_WEEK.equals(handler.getParserName())) {
                    vals.add(ExpressionDetermineUtils.days.indexOf(arr[i]) + 1);
                } else {
                    vals.add(Integer.parseInt(arr[i]));
                }
            } else {
                throw new InvalidCronExpression("Invalid expression");
            }
        }

        result.computeIfAbsent(handler.getParserName(), k -> new ArrayList<>()).addAll(vals);
    }
}