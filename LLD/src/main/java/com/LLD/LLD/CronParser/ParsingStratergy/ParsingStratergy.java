package CronParser.ParsingStratergy;

import CronParser.Chain.CronChainHandler;

import java.util.List;
import java.util.Map;

public interface ParsingStratergy {

    void parse(String partialString, CronChainHandler handler, Map<String, List<Integer>> result);
}
