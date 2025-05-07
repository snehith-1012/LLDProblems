package com.LLD.LLD.VendingMachine.changeReturner;

import com.LLD.LLD.VendingMachine.Note;
import com.LLD.LLD.VendingMachine.VendingMachine;
import com.LLD.LLD.VendingMachine.ChangeReturner;

import java.util.Iterator;

public class Returner5 implements ChangeReturner {

    private ChangeReturner nextChangeReturner;

    private int value = 5;

    public Returner5(ChangeReturner nextChangeReturner) {
        this.nextChangeReturner = nextChangeReturner;
    }

    @Override
    public void returnChange(VendingMachine vendingMachine, int amount) {
        if (canHandle(amount)) {
            int cnt = amount / value;
            int remaining = amount % value;
            Iterator<Note> iterator = vendingMachine.getNotes().iterator();
            System.out.println("returning " + cnt + " 5 rupee number of notes");
            while (iterator.hasNext() && cnt > 0) {
                if (iterator.next().getValue() == value) {
                    iterator.remove();
                    cnt--;
                }
            }
            this.nextChangeReturner.returnChange(vendingMachine, remaining);
        } else {
            this.nextChangeReturner.returnChange(vendingMachine, amount);
        }
    }

    @Override
    public boolean canHandle(int amount) {
        return amount >= 5;
    }
}
