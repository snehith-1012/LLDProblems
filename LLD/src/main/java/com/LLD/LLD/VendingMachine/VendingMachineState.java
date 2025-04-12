package com.LLD.LLD.VendingMachine;

import java.util.List;

public interface VendingMachineState {

    void insertNote(List<Note> notes, VendingMachine vendingMachine) throws Exception;

    void selectProduct(int id, int quantity, VendingMachine vendingMachine) throws Exception;

    void dispenseProduct(VendingMachine vendingMachine, int id, int quantity) throws Exception;

    void returnChange(VendingMachine vendingMachine) throws Exception;
}
