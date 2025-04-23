package com.LLD.LLD.AudioConverter;

import java.util.List;

public class Audio {

    private String audioName;

    private List<Integer> audioData;

    public Audio(String audioName, List<Integer> audioData) {
        this.audioName = audioName;
        this.audioData = audioData;
    }
}
