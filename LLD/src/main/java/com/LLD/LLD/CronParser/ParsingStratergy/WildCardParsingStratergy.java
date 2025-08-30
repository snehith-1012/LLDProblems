package com.LLD.LLD.CronParser.ParsingStratergy;

import com.LLD.LLD.CronParser.Chain.CronChainHandler;
import com.LLD.LLD.CronParser.Exceptions.InvalidCronExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.LLD.LLD.CronParser.Constants.TimeMeasurmentConstants.DAY_OF_MONTH;
import static com.LLD.LLD.CronParser.Constants.TimeMeasurmentConstants.DAY_OF_WEEK;
import static com.LLD.LLD.CronParser.Constants.cronExpressionConstants.QUESTION_MARK;
import static com.LLD.LLD.CronParser.Constants.cronExpressionConstants.STAR;

public class WildCardParsingStratergy implements ParsingStratergy {

    @Override
    public void parse(String partialString, CronChainHandler handler, Map<String, List<Integer>> result) {
        List<Integer> vals = new ArrayList<>();
        if (QUESTION_MARK.equals(partialString) && (DAY_OF_WEEK.equals(handler.getParserName()) || DAY_OF_MONTH.equals(handler.getParserName()))) {

        } else if (QUESTION_MARK.equals(partialString)) {
            throw new InvalidCronExpression("either day of week or day of month should be optional");
        } else if (STAR.equals(partialString)) {
            vals.addAll(handler.getAllValues());
        }
        result.computeIfAbsent(handler.getParserName(), k -> new ArrayList<>()).addAll(vals);
    }
}
