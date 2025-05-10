package com.LLD.LLD.cultfit;

import com.LLD.LLD.cultfit.enums.BookingStatusTypeEnum;
import com.LLD.LLD.cultfit.enums.WorkOutTypeEnum;

public class Booking {

    private String id;

    private BookingStatusTypeEnum bookingStatustypeEnum;

    private String slotId;

    private WorkOutTypeEnum workOutTypeEnum;

    private String gymId;


    public Booking(String id, BookingStatusTypeEnum bookingStatustypeEnum, String slotId, WorkOutTypeEnum workOutTypeEnum, String gymId) {
        this.id = id;
        this.bookingStatustypeEnum = bookingStatustypeEnum;
        this.slotId = slotId;
        this.workOutTypeEnum = workOutTypeEnum;
        this.gymId = gymId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BookingStatusTypeEnum getBookingStatustypeEnum() {
        return bookingStatustypeEnum;
    }

    public void setBookingStatustypeEnum(BookingStatusTypeEnum bookingStatustypeEnum) {
        this.bookingStatustypeEnum = bookingStatustypeEnum;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public WorkOutTypeEnum getWorkOutTypeEnum() {
        return workOutTypeEnum;
    }

    public void setWorkOutTypeEnum(WorkOutTypeEnum workOutTypeEnum) {
        this.workOutTypeEnum = workOutTypeEnum;
    }

    public String getGymId() {
        return gymId;
    }

    public void setGymId(String gymId) {
        this.gymId = gymId;
    }

    @Override
    public String toString() {
        return this.id + " " + this.getGymId() + " " + this.workOutTypeEnum.getName() + " " + this.slotId + " " + this.bookingStatustypeEnum.getName();
    }
}
