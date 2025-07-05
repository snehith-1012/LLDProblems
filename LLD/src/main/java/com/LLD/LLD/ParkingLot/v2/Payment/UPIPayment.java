package com.LLD.LLD.ParkingLot.v2.Payment;

public class UPIPayment implements PaymentStratergy {

    @Override
    public void pay(int amount) {
        // Logic to process UPI payment
        System.out.println("UPI payment of amount: " + amount + " processed successfully.");
    }
}
