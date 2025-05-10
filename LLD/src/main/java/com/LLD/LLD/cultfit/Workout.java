package com.LLD.LLD.cultfit;

import com.LLD.LLD.cultfit.enums.WorkOutTypeEnum;

import java.util.List;

public interface Workout {

    // admin
    void addSlot(Slot slot);

    void cancelSlot(String id);

    void DisplaySlots();

    // user

    void bookSlotForUser(String gymId, WorkOutTypeEnum workOutTypeEnum, String slotId, User user);

    void cancelBooking(Booking booking, User user);

}
