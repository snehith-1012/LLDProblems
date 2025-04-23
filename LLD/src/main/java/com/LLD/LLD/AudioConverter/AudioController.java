package com.LLD.LLD.AudioConverter;

import com.LLD.LLD.AudioConverter.AudioOperationData.AudioEnhancingOperationData;
import com.LLD.LLD.AudioConverter.AudioOperationData.AudioMergingOperationData;
import com.LLD.LLD.AudioConverter.AudioOperationData.AudioSplittingOperationData;
import com.LLD.LLD.AudioConverter.AudioOperationData.BitRateIncreasingOperationData;

import java.util.*;

public class AudioController {

    public static void main(String[] args) {
        AudioService audioService = new AudioService();

        // create Audio OperationsData

        AudioEnhancingOperationData audioEnhancingOperationData = new AudioEnhancingOperationData(2);
        AudioMergingOperationData audioMergingOperationData = new AudioMergingOperationData(List.of(3, 4));
        AudioSplittingOperationData audioSplittingOperationData = new AudioSplittingOperationData(3);
        BitRateIncreasingOperationData bitRateIncreasingOperationData = new BitRateIncreasingOperationData("increase");

        Audio audio1 = new Audio("audio1", List.of(1, 2));

        List<Map.Entry<AudioDataEnum, OperationData>> operations = new ArrayList<>();

        // choose any 1 or more options from below to test
        operations.add(new AbstractMap.SimpleEntry<>(AudioDataEnum.SPLITTING, audioSplittingOperationData));
        operations.add(new AbstractMap.SimpleEntry<>(AudioDataEnum.BIT_RATE_INCREASING, bitRateIncreasingOperationData));
        operations.add(new AbstractMap.SimpleEntry<>(AudioDataEnum.ENHANCING, audioEnhancingOperationData));
        operations.add(new AbstractMap.SimpleEntry<>(AudioDataEnum.MERGING, audioMergingOperationData));

        Audio convertedAudio = audioService.convertAudio(audio1, operations);


    }


}
