package com.LLD.LLD.cultfit.enums;

public enum WorkOutTypeEnum {
    GYM("gym"),
    YOGA("yoga");

    private String name;

    WorkOutTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
