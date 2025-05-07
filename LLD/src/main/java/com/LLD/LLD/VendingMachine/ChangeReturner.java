package com.LLD.LLD.VendingMachine;

import com.LLD.LLD.VendingMachine.VendingMachine;

public interface ChangeReturner {

    void returnChange(VendingMachine vendingMachine, int amount);

    boolean canHandle(int amount);
}
