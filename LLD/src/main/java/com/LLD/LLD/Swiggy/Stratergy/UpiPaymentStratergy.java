package com.LLD.LLD.Swiggy.Stratergy;

public class UpiPaymentStratergy implements PaymentStratergy {
    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid through upi");
    }
}
