package com.LLD.LLD.TrafficManagement;

public class Signal {

    private LightTypeEnum lightTypeEnum;

    public Signal(LightTypeEnum lightTypeEnum) {
        this.lightTypeEnum = lightTypeEnum;
    }

    public LightTypeEnum getLightTypeEnum() {
        return lightTypeEnum;
    }

    public void setLightTypeEnum(LightTypeEnum lightTypeEnum) {
        this.lightTypeEnum = lightTypeEnum;
    }
}
