package com.LLD.LLD.VendingMachine;

public enum Note {
    ONE(1),
    FIVE(5),
    TEN(10),
    TWENTY(20);

    private final int value;

    Note(int val){
        this.value = val;
    }

    public int getValue(){
        return this.value;
    }

}
