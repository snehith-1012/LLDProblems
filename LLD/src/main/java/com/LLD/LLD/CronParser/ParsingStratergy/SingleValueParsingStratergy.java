package com.LLD.LLD.CronParser.ParsingStratergy;

import com.LLD.LLD.CronParser.Chain.CronChainHandler;
import com.LLD.LLD.CronParser.Utils.ExpressionDetermineUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.LLD.LLD.CronParser.Constants.TimeMeasurmentConstants.DAY_OF_WEEK;
import static com.LLD.LLD.CronParser.Constants.TimeMeasurmentConstants.MONTH;

public class SingleValueParsingStratergy implements ParsingStratergy {

    private static volatile ParsingStratergy singleValueParsingStratergy;

    public static ParsingStratergy getInstance() {
        if (singleValueParsingStratergy == null) {
            synchronized (SingleValueParsingStratergy.class) {
                if (singleValueParsingStratergy == null) {
                    singleValueParsingStratergy = new SingleValueParsingStratergy();
                }
            }
        }
        return singleValueParsingStratergy;
    }

    @Override
    public void parse(String partialString, CronChainHandler handler, Map<String, List<Integer>> result) {

        List<Integer> vals = new ArrayList<>();
        if (handler.isInputWithInConstraints(partialString)) {
            if (MONTH.equals(handler.getParserName())) {
                vals.add(ExpressionDetermineUtils.months.indexOf(partialString) + 1);
            } else if (DAY_OF_WEEK.equals(handler.getParserName())) {
                vals.add(ExpressionDetermineUtils.days.indexOf(partialString) + 1);
            } else {
                vals.add(Integer.parseInt(partialString));
            }
        }
        result.computeIfAbsent(handler.getParserName(), k -> new ArrayList<>()).addAll(vals);
    }
}
