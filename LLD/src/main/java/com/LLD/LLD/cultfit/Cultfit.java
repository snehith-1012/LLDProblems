package com.LLD.LLD.cultfit;

import com.LLD.LLD.cultfit.enums.UserTypeEnum;
import com.LLD.LLD.cultfit.enums.WorkOutTypeEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cultfit {
    private Map<String, Gym> gyms;

    private static Cultfit cultfit;


    private Cultfit(Map<String, Gym> gyms) {
        this.gyms = gyms;
    }

    public static synchronized Cultfit getInstance() {
        if (cultfit == null) {
            return cultfit = new Cultfit(new HashMap<>());
        }
        return cultfit;
    }

    public void intialiseGyms() {
        this.gyms.put("1", new Gym("1", new HashMap<>()));
        this.gyms.put("2", new Gym("2", new HashMap<>()));
    }

    // admin
    public void registerGym(Gym gym) {
        this.gyms.put(gym.getGymId(), gym);
    }

    public void addWorkoutSlotForAGym(String gymId, WorkOutTypeEnum workOutTypeEnum, Slot slot) {
        this.gyms.get(gymId).addWorkoutSlot(workOutTypeEnum, slot);
    }

    public void cancelWorkOutSlotForAGym(String gymId, WorkOutTypeEnum workOutTypeEnum, String slotId) {
        this.gyms.get(gymId).cancelWorkOutSlot(workOutTypeEnum, slotId);
    }

    public void displayWorkOutSlotsForAGym(String gymId, WorkOutTypeEnum workOutTypeEnum) {
        this.gyms.get(gymId).getWorkouts().get(workOutTypeEnum).DisplaySlots();
    }

    // users
    public void bookWorkOutSlot(String gymId, WorkOutTypeEnum workOutTypeEnum, String slotId, User user) {
        if (user.getUserTypeEnum() == UserTypeEnum.CUSTOMER) {
            this.gyms.get(gymId).bookWorkOutSlot(gymId, workOutTypeEnum, slotId, user);
        }
    }

    public void cancelWorkOutSlot(String bookingId, User user) {
        if (user.getUserTypeEnum() == UserTypeEnum.CUSTOMER) {
            Booking booking = user.getBookings().get(bookingId);
            this.gyms.get(booking.getGymId()).CancelBooking(booking, user);
        }
    }

    public Map<String, Gym> getGyms() {
        return gyms;
    }

    public void setGyms(Map<String, Gym> gyms) {
        this.gyms = gyms;
    }
}
