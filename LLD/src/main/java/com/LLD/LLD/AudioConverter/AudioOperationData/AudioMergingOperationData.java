package com.LLD.LLD.AudioConverter.AudioOperationData;

import com.LLD.LLD.AudioConverter.Audio;
import com.LLD.LLD.AudioConverter.OperationData;

import java.util.List;

public class AudioMergingOperationData implements OperationData {

    private List<Integer> audioMergeOperationData;


    public AudioMergingOperationData(List<Integer> audioMergeOperationData) {
        this.audioMergeOperationData = audioMergeOperationData;
    }

    public List<Integer> getAudioMergeOperationData() {
        return audioMergeOperationData;
    }

    public void setAudioMergeOperationData(List<Integer> audioMergeOperationData) {
        this.audioMergeOperationData = audioMergeOperationData;
    }
}
