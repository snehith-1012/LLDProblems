package com.LLD.LLD.cultfit;

import com.LLD.LLD.cultfit.enums.WorkOutTypeEnum;
import com.LLD.LLD.cultfit.workout.GymWorkout;
import com.LLD.LLD.cultfit.workout.YogaWorkout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gym {

    private String gymId;

    private Map<WorkOutTypeEnum, Workout> workouts;


    public Gym(String gymId, Map<WorkOutTypeEnum, Workout> workouts) {
        this.gymId = gymId;
        this.workouts = workouts;
    }

    public void intialiseWorkOuts() {
        Map<String, Slot> slots = new HashMap<>();
        slots.put("1", new Slot("1", 9, 10, 3));
        slots.put("2", new Slot("2", 4, 5, 4));
        workouts.put(WorkOutTypeEnum.GYM, new GymWorkout(WorkOutTypeEnum.GYM, slots));
        workouts.put(WorkOutTypeEnum.YOGA, new YogaWorkout(WorkOutTypeEnum.YOGA, slots));
    }

    // users
    public void bookWorkOutSlot(String gymId, WorkOutTypeEnum workOutTypeEnum, String slotId, User user) {
        this.getWorkouts().get(workOutTypeEnum).bookSlotForUser(gymId,workOutTypeEnum, slotId, user);
    }

    public void CancelBooking(Booking booking, User user) {
        this.getWorkouts().get(booking.getWorkOutTypeEnum()).cancelBooking(booking, user);
    }

    // admin
    public void addWorkoutSlot(WorkOutTypeEnum workOutTypeEnum, Slot slot) {
        if (!workouts.containsKey(workOutTypeEnum)) {
            Map<String, Slot> slots = new HashMap<>();
            slots.put(slot.getId(), slot);
            if (workOutTypeEnum == WorkOutTypeEnum.GYM) {
                this.workouts.put(workOutTypeEnum, new GymWorkout(WorkOutTypeEnum.GYM, slots));
            } else {
                this.workouts.put(WorkOutTypeEnum.YOGA, new YogaWorkout(WorkOutTypeEnum.YOGA, slots));
            }
        } else {
            workouts.get(workOutTypeEnum).addSlot(slot);
        }
    }

    public void cancelWorkOutSlot(WorkOutTypeEnum workOutTypeEnum, String slotId) {
        workouts.get(workOutTypeEnum).cancelSlot(slotId);
    }

    public void displayWorkOutSlots(WorkOutTypeEnum workOutTypeEnum) {
        workouts.get(workOutTypeEnum).DisplaySlots();
    }

    public String getGymId() {
        return gymId;
    }

    public void setGymId(String gymId) {
        this.gymId = gymId;
    }

    public Map<WorkOutTypeEnum, Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(Map<WorkOutTypeEnum, Workout> workouts) {
        this.workouts = workouts;
    }
}
