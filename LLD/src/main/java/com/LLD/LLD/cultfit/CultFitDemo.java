package com.LLD.LLD.cultfit;

import com.LLD.LLD.cultfit.enums.UserTypeEnum;
import com.LLD.LLD.cultfit.enums.WorkOutTypeEnum;

import java.util.HashMap;

public class CultFitDemo {

    public static void main(String[] args) {
        Cultfit cultfit = Cultfit.getInstance();

        cultfit.intialiseGyms();

        cultfit.getGyms().get("1").intialiseWorkOuts();
        cultfit.getGyms().get("2").intialiseWorkOuts();

        // admin
        User adminUser = new User("5", UserTypeEnum.ADMIN, "8767993");

        // register gym
        Gym gym1 = new Gym("3", new HashMap<>());
        Gym gym2 = new Gym("4", new HashMap<>());
        cultfit.registerGym(gym1);
        cultfit.registerGym(gym2);

        // add work out slots
        cultfit.addWorkoutSlotForAGym(adminUser, "3", WorkOutTypeEnum.YOGA, new Slot("1", 6, 7, 3));
        cultfit.addWorkoutSlotForAGym(adminUser, "3", WorkOutTypeEnum.YOGA, new Slot("3", 10, 11, 1));
        cultfit.addWorkoutSlotForAGym(adminUser, "4", WorkOutTypeEnum.GYM, new Slot("2", 7, 8, 2));

        // display work out slots
        cultfit.displayWorkOutSlotsForAGym(adminUser, "3", WorkOutTypeEnum.YOGA);
        cultfit.displayWorkOutSlotsForAGym(adminUser, "4", WorkOutTypeEnum.GYM);

        // cancel work out slot
        cultfit.cancelWorkOutSlotForAGym(adminUser, "4", WorkOutTypeEnum.GYM, "2");

        // display cancelled workout slots
        cultfit.displayWorkOutSlotsForAGym(adminUser,"4", WorkOutTypeEnum.GYM);

        // users
        // book slot for user
        User user1 = new User("snehith", UserTypeEnum.CUSTOMER, "8464876114");
//        cultfit.bookWorkOutSlot("3",WorkOutTypeEnum.YOGA,"1",user1);
//        cultfit.bookWorkOutSlot("4",WorkOutTypeEnum.GYM,"2",user1);

        // cancel slot for user
//        cultfit.cancelWorkOutSlot("1",user1);

        // display user bookings
        for (String bookingId : user1.getBookings().keySet()) {
            Booking booking = user1.getBookings().get(bookingId);
            System.out.println(booking.toString());
        }


        User user2 = new User("avinash", UserTypeEnum.CUSTOMER, "67598769");

        cultfit.bookWorkOutSlot("3", WorkOutTypeEnum.YOGA, "3", user1);
        cultfit.bookWorkOutSlot("3", WorkOutTypeEnum.YOGA, "3", user2);
        cultfit.cancelWorkOutSlot("1", user1);

        System.out.println("2");
    }
}
