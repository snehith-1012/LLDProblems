package com.LLD.LLD.cultfit.workout;

import com.LLD.LLD.cultfit.Booking;
import com.LLD.LLD.cultfit.Slot;
import com.LLD.LLD.cultfit.User;
import com.LLD.LLD.cultfit.enums.WorkOutTypeEnum;
import com.LLD.LLD.cultfit.Workout;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

public class YogaWorkout implements Workout {

    private WorkOutTypeEnum workOutTypeEnum;
    private Map<String, Slot> slots;

    public YogaWorkout(WorkOutTypeEnum workOutTypeEnum, Map<String, Slot> slots) {
        this.workOutTypeEnum = workOutTypeEnum;
        this.slots = slots;
    }

    @Override
    public void addSlot(Slot slot) {
        this.slots.put(slot.getId(), slot);
    }

    @Override
    public void cancelSlot(String id) {
        Slot slot = this.slots.get(id);
        if (!CollectionUtils.isEmpty(slot.getUsers())) {
            slot.getUsers().forEach((user) -> user.notifySlotCancellation(slot));
        }
        this.slots.remove(slot.getId());
    }

    @Override
    public void DisplaySlots() {
        System.out.println("Available slots");
        for (String slotId : this.slots.keySet()) {
            Slot slot = this.slots.get(slotId);
            System.out.println("start time" + slot.getStartTime() + " end time" + slot.getEndTime() + "available slots" + (slot.getAvailableCapacity() - slot.getCurrentCapacity()));
        }
    }

    @Override
    public void bookSlotForUser(String gymId, WorkOutTypeEnum workOutTypeEnum, String slotId, User user) {
        this.getSlots().get(slotId).bookSlotForUser(gymId, workOutTypeEnum, slotId, user);
    }

    @Override
    public void cancelBooking(Booking booking, User user) {
        this.getSlots().get(booking.getSlotId()).cancelSlotForUser(booking, user);
    }

    public WorkOutTypeEnum getWorkOutTypeEnum() {
        return workOutTypeEnum;
    }

    public void setWorkOutTypeEnum(WorkOutTypeEnum workOutTypeEnum) {
        this.workOutTypeEnum = workOutTypeEnum;
    }

    public Map<String, Slot> getSlots() {
        return slots;
    }

    public void setSlots(Map<String, Slot> slots) {
        this.slots = slots;
    }
}
