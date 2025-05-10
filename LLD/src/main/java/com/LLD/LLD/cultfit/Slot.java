package com.LLD.LLD.cultfit;

import com.LLD.LLD.cultfit.enums.BookingStatusTypeEnum;
import com.LLD.LLD.cultfit.enums.WorkOutTypeEnum;

import java.util.*;

public class Slot {

    private String id;
    private int startTime;

    private int endTime;

    private int availableCapacity;

    private int currentCapacity;

    private List<User> users;

    private Queue<User> waitListUsers;

    public Slot(String id, int startTime, int endTime, int availableCapacity) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.availableCapacity = availableCapacity;
        this.currentCapacity = 0;
        this.waitListUsers = new LinkedList<>();
        this.users = new ArrayList<>();
    }

    public void bookSlotForUser(String gymId, WorkOutTypeEnum workOutTypeEnum, String slotId, User user) {
        if (this.currentCapacity < this.availableCapacity) {
            this.users.add(user);
            this.currentCapacity++;
            String bookingId = Integer.toString(user.getBookings().size() + 1);
            user.addBooking(new Booking(bookingId, BookingStatusTypeEnum.ATTENDED, slotId, workOutTypeEnum, gymId));
            user.notifySlotBooking(this);
        } else {
            this.waitListUsers.add(user);
        }
    }

    public void cancelSlotForUser(Booking booking, User user) {
        if (currentCapacity == availableCapacity) {
            currentCapacity--;
            this.users.remove(user);
            Booking booking1 = user.getBookings().get(booking.getId());
            booking1.setBookingStatustypeEnum(BookingStatusTypeEnum.CANCELLED);
            if (!waitListUsers.isEmpty()) {
                User waitingUser = this.waitListUsers.poll();
                this.users.add(waitingUser);
                String bookingId = Integer.toString(waitingUser.getBookings().size() + 1);
                waitingUser.addBooking(new Booking(bookingId, BookingStatusTypeEnum.ATTENDED, booking.getSlotId(), booking1.getWorkOutTypeEnum(), booking1.getSlotId()));
                waitingUser.notifySlotBooking(this);
                currentCapacity++;
            }
        } else {
            this.users.remove(user);
            Booking booking1 = user.getBookings().get(booking.getId());
            booking1.setBookingStatustypeEnum(BookingStatusTypeEnum.CANCELLED);
            currentCapacity--;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getAvailableCapacity() {
        return availableCapacity;
    }

    public void setAvailableCapacity(int availableCapacity) {
        this.availableCapacity = availableCapacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Queue<User> getWaitListUsers() {
        return waitListUsers;
    }

    public void setWaitListUsers(Queue<User> waitListUsers) {
        this.waitListUsers = waitListUsers;
    }
}
