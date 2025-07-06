package com.LLD.LLD.HotelManagement.Payment;

public interface PaymentStratergy {

    void pay(int amount);

    void refund(int amount);
}
