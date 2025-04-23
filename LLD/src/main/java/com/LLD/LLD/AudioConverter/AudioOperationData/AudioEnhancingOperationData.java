package com.LLD.LLD.AudioConverter.AudioOperationData;

import com.LLD.LLD.AudioConverter.Operation;
import com.LLD.LLD.AudioConverter.OperationData;

public class AudioEnhancingOperationData implements OperationData {

    private int enhanceRateOperationData;

    public AudioEnhancingOperationData(int enhanceRateOperationData) {
        this.enhanceRateOperationData = enhanceRateOperationData;
    }

    public int getEnhanceRateOperationData() {
        return enhanceRateOperationData;
    }

    public void setEnhanceRateOperationData(int enhanceRateOperationData) {
        this.enhanceRateOperationData = enhanceRateOperationData;
    }
}
