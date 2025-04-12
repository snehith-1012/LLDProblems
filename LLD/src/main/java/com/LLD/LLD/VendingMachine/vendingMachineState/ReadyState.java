package com.LLD.LLD.VendingMachine.vendingMachineState;

import com.LLD.LLD.VendingMachine.*;

import java.util.List;

public class ReadyState implements VendingMachineState {

    @Override
    public void insertNote(List<Note> notes, VendingMachine vendingMachine) throws Exception {
        throw new Exception("not in a state to accept money");
    }

    @Override
    public void selectProduct(int id, int quantity, VendingMachine vendingMachine) throws Exception {
        if (vendingMachine.getShelves().stream().filter(shelf -> shelf.getShelfId() == id).toList().size() == 0) {
            vendingMachine.returnChangeToUser(vendingMachine.getUserMoney());
            vendingMachine.setMoney(vendingMachine.getMoney() - vendingMachine.getUserMoney());
            vendingMachine.setVendingMachineState(new IdleState());
            throw new Exception("item not found");
        }
        int sumOfUserRequestedProductsCost = quantity * vendingMachine.getShelves().stream().filter(shelf -> shelf.getShelfId() == id).toList().get(0).getProduct().getPrice();
        int availableQuantity = vendingMachine.getShelves().stream().filter(shelf -> shelf.getShelfId() == id).toList().get(0).getQuantity();
        if (vendingMachine.getUserMoney() < sumOfUserRequestedProductsCost) {
            vendingMachine.setMoney(vendingMachine.getMoney() - vendingMachine.getUserMoney());
            vendingMachine.returnChangeToUser(vendingMachine.getUserMoney());
            vendingMachine.setVendingMachineState(new IdleState());
            throw new Exception("money not sufficient to buy products");
        }
        if (availableQuantity < quantity) {
            vendingMachine.returnChangeToUser(vendingMachine.getUserMoney());
            vendingMachine.setMoney(vendingMachine.getMoney() - vendingMachine.getUserMoney());
            vendingMachine.setVendingMachineState(new IdleState());
            throw new Exception("the quantity you requested is not available");
        }
        vendingMachine.setMoney(vendingMachine.getMoney() + sumOfUserRequestedProductsCost);
        vendingMachine.updateUserMoney(vendingMachine.getUserMoney() - sumOfUserRequestedProductsCost);
        vendingMachine.setVendingMachineState(new DispenseState());
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
