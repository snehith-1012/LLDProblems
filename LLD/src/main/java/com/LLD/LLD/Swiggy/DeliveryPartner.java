package com.LLD.LLD.Swiggy;


import com.LLD.LLD.Swiggy.Enum.UserAvailabilityEnum;
import com.LLD.LLD.Swiggy.Enum.UserTypeEnum;

public class DeliveryPartner extends User {

    private UserAvailabilityEnum userAvailabilityEnum;

    public UserAvailabilityEnum getUserAvailabilityEnum() {
        return userAvailabilityEnum;
    }

    public void setUserAvailabilityEnum(UserAvailabilityEnum userAvailabilityEnum) {
        this.userAvailabilityEnum = userAvailabilityEnum;
    }

    public DeliveryPartner(int userId, String name, UserAvailabilityEnum userAvailabilityEnum) {
        super(userId, name, UserTypeEnum.DELIVERY_PARTNER);
        this.userAvailabilityEnum = userAvailabilityEnum;
    }
}
