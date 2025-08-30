package CronParser.Utils;

import java.util.Arrays;
import java.util.List;

import static CronParser.Constants.cronExpressionConstants.*;
import static CronParser.Constants.cronExpressionConstants.COMMA;
import static CronParser.Constants.cronExpressionConstants.HYPHEN;
import static CronParser.Constants.cronExpressionConstants.QUESTION_MARK;
import static CronParser.Constants.cronExpressionConstants.SLASH;
import static CronParser.Constants.cronExpressionConstants.STAR;

public class ExpressionDetermineUtils {

    public static final List<String> days = Arrays.asList("MON","TUE","WED","THU","FRI","SAT","SUN");

    public static final List<String> months = Arrays.asList("JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC");

    public static boolean isRangeOrStepExpression(String partialExpression) {
        return !partialExpression.contains(",") && (partialExpression.contains(SLASH) || partialExpression.contains(HYPHEN));
    }

    public static boolean isCommaSeperatedListExpression(String partialExpression) {
        return partialExpression.contains(COMMA);
    }

    public static boolean doesContainOnlyWildCard(String partialExpression) {
        return partialExpression.length() == 1 && (partialExpression.equals(STAR) || partialExpression.equals(QUESTION_MARK));
    }

    public static boolean isOnlySpecialCharacters(String partialExpression) {
        return !partialExpression.contains(SLASH)
                && !partialExpression.contains(HYPHEN)
                && !partialExpression.contains(COMMA)
                && !partialExpression.contains(STAR)
                && !partialExpression.contains(QUESTION_MARK)
                && (partialExpression.contains("L") || partialExpression.contains("W"));
    }

    public static boolean isSingleValue(String partialExpression) {
        try {
            return Integer.valueOf(partialExpression) >= 0 || days.contains(partialExpression) || months.contains(partialExpression);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
