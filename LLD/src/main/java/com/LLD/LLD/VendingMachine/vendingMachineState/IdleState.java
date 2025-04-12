package com.LLD.LLD.VendingMachine.vendingMachineState;

import com.LLD.LLD.VendingMachine.*;

import java.util.List;

public class IdleState implements VendingMachineState {

    @Override
    public void insertNote(List<Note> notes, VendingMachine vendingMachine) {
        int sum = 0;
        for (Note note : notes) {
            sum += note.getValue();
        }
        vendingMachine.updateUserMoney(sum);
        vendingMachine.setMoney(vendingMachine.getMoney()+sum);
        vendingMachine.updateNotes(notes);
        // state update
        vendingMachine.setVendingMachineState(new ReadyState());
    }

    @Override
    public void selectProduct(int id, int quantity, VendingMachine vendingMachine) throws Exception {
        throw new Exception("first enter the money");
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine, int id, int quantity) throws Exception {
        throw new Exception("Incorrect state");
    }

    @Override
    public void returnChange(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Incorrect state");
    }
}
