package com.LLD.LLD.VendingMachine.vendingMachineState;

import com.LLD.LLD.VendingMachine.*;

import java.util.List;

public class DispenseState implements VendingMachineState {


    @Override
    public void insertNote(List<Note> notes, VendingMachine vendingMachine) {
        new Exception("not in a state to accept money");
    }

    @Override
    public void selectProduct(int id, int quantity, VendingMachine vendingMachine) throws Exception {
        throw new Exception("product already selected collect your product");
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine, int id, int quantity) throws Exception {
        Shelf shelf = vendingMachine.getShelves().stream().filter(shelf1 -> shelf1.getShelfId() == id).toList().get(0);
        shelf.setQuantity(shelf.getQuantity() - quantity);
        if (vendingMachine.getUserMoney() == 0) {
            shelf.setQuantity(shelf.getQuantity() - quantity);
            vendingMachine.setVendingMachineState(new IdleState());
        } else {
            vendingMachine.setVendingMachineState(new ReturnChangeState());
            vendingMachine.getVendingMachineState().returnChange(vendingMachine);
        }
    }

    @Override
    public void returnChange(VendingMachine vendingMachine) throws Exception {
        throw new Exception(" dispensing products please wait");
    }
}
