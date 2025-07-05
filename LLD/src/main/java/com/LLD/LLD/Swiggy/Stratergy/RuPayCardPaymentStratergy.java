package com.LLD.LLD.Swiggy.Stratergy;

public class RuPayCardPaymentStratergy implements PaymentStratergy {
    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid through card");
    }
}
