package com.LLD.LLD.AudioConverter.AudioOperationData;

import com.LLD.LLD.AudioConverter.OperationData;

import java.util.List;

public class AudioSplittingOperationData implements OperationData {

    private int placeOfSplit;

    public AudioSplittingOperationData(int placeOfSplit) {
        this.placeOfSplit = placeOfSplit;
    }

    public int getPlaceOfSplit() {
        return placeOfSplit;
    }

    public void setPlaceOfSplit(int placeOfSplit) {
        this.placeOfSplit = placeOfSplit;
    }
}
