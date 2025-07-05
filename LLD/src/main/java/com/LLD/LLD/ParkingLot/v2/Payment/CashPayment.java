package com.LLD.LLD.ParkingLot.v2.Payment;

public class CashPayment implements PaymentStratergy {
    @Override
    public void pay(int amount) {
        System.out.println("cahs payment of amount: " + amount + " processed successfully.");
    }
}
