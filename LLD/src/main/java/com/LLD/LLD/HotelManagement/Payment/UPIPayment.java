package com.LLD.LLD.HotelManagement.Payment;

public class UPIPayment implements PaymentStratergy {


    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using UPI.");
    }

    @Override
    public void refund(int amount) {
        System.out.println("Refunded " + amount + " using UPI.");
    }
}
