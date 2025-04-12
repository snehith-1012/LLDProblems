package com.LLD.LLD.VendingMachine;

import java.util.List;

public class VendingMachineDemo {

    public static void main(String args[]) throws Exception {
        VendingMachine vendingMachine = VendingMachine.getInstance();

        vendingMachine.insertMoney(List.of(Note.TEN, Note.FIVE));

        vendingMachine.selectProduct(101, 1);
    }
}
