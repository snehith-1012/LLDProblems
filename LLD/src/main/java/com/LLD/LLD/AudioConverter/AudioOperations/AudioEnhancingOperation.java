package com.LLD.LLD.AudioConverter.AudioOperations;

import com.LLD.LLD.AudioConverter.Audio;
import com.LLD.LLD.AudioConverter.AudioOperationData.AudioEnhancingOperationData;
import com.LLD.LLD.AudioConverter.AudioOperationData.AudioMergingOperationData;
import com.LLD.LLD.AudioConverter.Operation;
import com.LLD.LLD.AudioConverter.OperationData;

import java.util.List;
import java.util.Map;

public class AudioEnhancingOperation implements Operation {

    private OperationData operationData;
    private Operation nextOperation;

    public AudioEnhancingOperation(OperationData operationData, Operation nextOperation) {
        this.operationData = operationData;
        this.nextOperation = nextOperation;
    }

    public OperationData getOperationData() {
        return operationData;
    }

    public void setOperationData(OperationData operationData) {
        this.operationData = operationData;
    }

    public Operation getNextOperation() {
        return nextOperation;
    }

    public void setNextOperation(Operation nextOperation) {
        this.nextOperation = nextOperation;
    }

    @Override
    public Audio doOperation(Audio audio, List<Operation> operations, int ind) {
        if (ind >= operations.size()) {
            return audio;
        }
        if (operations.get(ind) == this) {
            audio = modifyAudio(audio, this.operationData);
        }
        return audio;
    }

    private Audio modifyAudio(Audio audio, OperationData operationData) {
        System.out.println("enhancement options" + ((AudioEnhancingOperationData) operationData).getEnhanceRateOperationData());
        return audio;
    }
}
