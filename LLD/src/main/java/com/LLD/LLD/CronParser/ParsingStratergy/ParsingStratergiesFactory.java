package CronParser.ParsingStratergy;

import CronParser.Exceptions.InvalidCronExpression;
import CronParser.Utils.ExpressionDetermineUtils;

import java.lang.reflect.Array;
import java.util.Arrays;


public class ParsingStratergiesFactory {

    public static ParsingStratergy getParsingStratergy(String stringToBeParsed){
        if(ExpressionDetermineUtils.isRangeOrStepExpression(stringToBeParsed)){
            return new RangeAndStepParsingStratergy();
        } else if(ExpressionDetermineUtils.doesContainOnlyWildCard(stringToBeParsed)) {
            return new WildCardParsingStratergy();
        } else if(ExpressionDetermineUtils.isCommaSeperatedListExpression(stringToBeParsed)){
            return new ListParsingStratergy();
        } else if(ExpressionDetermineUtils.isOnlySpecialCharacters(stringToBeParsed)){
            return new SpecialCharacterParsingStratergy();
        } else if(ExpressionDetermineUtils.isSingleValue(stringToBeParsed)){
            return new SingleValueParsingStratergy();
        } else {
            throw new InvalidCronExpression("second's section is in invalid format");
        }
    }
}
