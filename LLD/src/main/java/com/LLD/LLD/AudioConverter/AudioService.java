package com.LLD.LLD.AudioConverter;


//take audio as input and it has various audio converters
//bit rate increaser
//splitter
//merger
//enhancer

import com.LLD.LLD.AudioConverter.AudioOperations.AudioEnhancingOperation;
import com.LLD.LLD.AudioConverter.AudioOperations.AudioMergingOperation;
import com.LLD.LLD.AudioConverter.AudioOperations.AudioSplittingOperation;
import com.LLD.LLD.AudioConverter.AudioOperations.BitRateIncreasingOperation;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AudioService {

    Operation audioEnhancingOperation = null;
    Operation audioSplittingOperation = null;
    Operation audioMergingOperation = null;
    Operation bitRateIncreasingOperation = null;

    public AudioService() {
        audioEnhancingOperation = new AudioEnhancingOperation(null, null);
        audioSplittingOperation = new AudioSplittingOperation(null, audioEnhancingOperation);
        audioMergingOperation = new AudioMergingOperation(null, audioSplittingOperation);
        bitRateIncreasingOperation = new BitRateIncreasingOperation(null, audioMergingOperation);
    }

    public Audio convertAudio(Audio audio, List<Map.Entry<AudioDataEnum, OperationData>> operations) {
        List<Operation> sortedOperations = sortOperations(operations);
        Audio convertedAudio = bitRateIncreasingOperation.doOperation(audio, sortedOperations, 0);
        return convertedAudio;
    }

    public List<Operation> sortOperations(List<Map.Entry<AudioDataEnum, OperationData>> operations) {
        List<Operation> sortedOperationsList = new ArrayList<>();

        int ind = checkIndex(operations, AudioDataEnum.BIT_RATE_INCREASING);
        if (ind != -1) {
            bitRateIncreasingOperation.setOperationData(operations.get(ind).getValue());
            sortedOperationsList.add(bitRateIncreasingOperation);
        }

        ind = checkIndex(operations, AudioDataEnum.MERGING);
        if (ind != -1) {
            audioMergingOperation.setOperationData(operations.get(ind).getValue());
            sortedOperationsList.add(audioMergingOperation);
        }

        ind = checkIndex(operations, AudioDataEnum.SPLITTING);
        if (ind != -1) {
            audioSplittingOperation.setOperationData(operations.get(ind).getValue());
            sortedOperationsList.add(audioSplittingOperation);
        }

        ind = checkIndex(operations, AudioDataEnum.ENHANCING);
        if (ind != -1) {
            audioEnhancingOperation.setOperationData(operations.get(ind).getValue());
            sortedOperationsList.add(audioEnhancingOperation);
        }
        return sortedOperationsList;
    }

    public int checkIndex(List<Map.Entry<AudioDataEnum, OperationData>> operations, AudioDataEnum audioDataEnum) {
        for (int i = 0; i < operations.size(); i++) {
            if (operations.get(i).getKey() == audioDataEnum) {
                return i;
            }
        }
        return -1;
    }

}
