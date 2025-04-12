package com.LLD.LLD.VendingMachine.vendingMachineState;

import com.LLD.LLD.VendingMachine.*;

import java.util.List;

public class ReturnChangeState implements VendingMachineState {

    @Override
    public void insertNote(List<Note> notes, VendingMachine vendingMachine) throws Exception {
        throw new Exception("not in a state to accept money");
    }

    @Override
    public void selectProduct(int id, int quantity, VendingMachine vendingMachine) throws Exception {
        throw new Exception("product already selected and  collected");
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine, int id, int quantity) throws Exception {
        throw new Exception("Incorrect state");
    }

    @Override
    public void returnChange(VendingMachine vendingMachine) {
        vendingMachine.returnChangeToUser(vendingMachine.getUserMoney());
        System.out.println("returned money to user");
    }
}
