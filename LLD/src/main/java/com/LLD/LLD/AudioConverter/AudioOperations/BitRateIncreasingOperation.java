package com.LLD.LLD.AudioConverter.AudioOperations;

import com.LLD.LLD.AudioConverter.Audio;
import com.LLD.LLD.AudioConverter.AudioOperationData.BitRateIncreasingOperationData;
import com.LLD.LLD.AudioConverter.Operation;
import com.LLD.LLD.AudioConverter.OperationData;

import java.util.List;
import java.util.Map;

public class BitRateIncreasingOperation implements Operation {

    private OperationData operationData;
    private Operation nextOperation;

    public BitRateIncreasingOperation(OperationData operationData, Operation nextOperation) {
        this.operationData = operationData;
        this.nextOperation = nextOperation;
    }

    public OperationData getOperationData() {
        return operationData;
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
            return this.nextOperation.doOperation(audio, operations, ind + 1);
        } else {
            return this.nextOperation.doOperation(audio, operations, ind);
        }
    }

    @Override
    public void setOperationData(OperationData operationData) {
        this.operationData = operationData;
    }

    private Audio modifyAudio(Audio audio, OperationData operationData) {
        System.out.println("audio changes to following settings " + ((BitRateIncreasingOperationData) operationData).getOperationData());
        return audio;
    }
}
