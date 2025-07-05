package com.LLD.LLD.ParkingLot.v2;

public class Ticket {

    private Integer ticketId;

    private Integer floorId;

    private Integer slotId;

    private Integer entryTime;

    private Integer exitTime;

    public Ticket(Integer ticketId, Integer floorId, Integer slotId, Integer entryTime, Integer exitTime) {
        this.ticketId = ticketId;
        this.floorId = floorId;
        this.slotId = slotId;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getFloorId() {
        return floorId;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
    }

    public Integer getSlotId() {
        return slotId;
    }

    public void setSlotId(Integer slotId) {
        this.slotId = slotId;
    }

    public Integer getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Integer entryTime) {
        this.entryTime = entryTime;
    }

    public Integer getExitTime() {
        return exitTime;
    }

    public void setExitTime(Integer exitTime) {
        this.exitTime = exitTime;
    }
}
