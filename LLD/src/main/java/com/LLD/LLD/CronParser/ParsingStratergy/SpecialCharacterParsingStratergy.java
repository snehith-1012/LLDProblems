package com.LLD.LLD.CronParser.ParsingStratergy;

import com.LLD.LLD.CronParser.Chain.CronChainHandler;

import java.util.List;
import java.util.Map;

public class SpecialCharacterParsingStratergy implements ParsingStratergy {
    private static volatile ParsingStratergy specialCharacterParsingStratergy;

    public static ParsingStratergy getInstance() {
        if (specialCharacterParsingStratergy == null) {
            synchronized (SpecialCharacterParsingStratergy.class) {
                if (specialCharacterParsingStratergy == null) {
                    specialCharacterParsingStratergy = new SingleValueParsingStratergy();
                }
            }
        }
        return specialCharacterParsingStratergy;
    }

    @Override
    public void parse(String partialString, CronChainHandler handler, Map<String, List<Integer>> result) {

    }
}
