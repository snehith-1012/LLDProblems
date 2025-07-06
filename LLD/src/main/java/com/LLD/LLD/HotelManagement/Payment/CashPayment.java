package com.LLD.LLD.HotelManagement.Payment;

public class CashPayment implements PaymentStratergy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Cash.");
    }

    @Override
    public void refund(int amount) {
        System.out.println("Refunded " + amount + " using Cash.");
    }
}
