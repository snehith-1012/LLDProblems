package com.LLD.LLD.AudioConverter.AudioOperationData;

import com.LLD.LLD.AudioConverter.OperationData;

public class BitRateIncreasingOperationData implements OperationData {
    private String operationData;

    public BitRateIncreasingOperationData(String operationData) {
        this.operationData = operationData;
    }

    public String getOperationData() {
        return operationData;
    }

    public void setOperationData(String operationData) {
        this.operationData = operationData;
    }
}
