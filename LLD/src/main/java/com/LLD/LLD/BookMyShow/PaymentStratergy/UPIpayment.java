package com.LLD.LLD.BookMyShow.PaymentStratergy;

public class UPIpayment implements PaymentStratergy{

    @Override
    public void pay(int amount) {
        System.out.println("Payment of " + amount + " made using UPI.");
    }
}
