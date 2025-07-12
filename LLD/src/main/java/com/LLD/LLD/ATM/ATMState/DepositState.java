package com.LLD.LLD.ATM.ATMState;

import com.LLD.LLD.ATM.ATM;
import com.LLD.LLD.ATM.NoteTypeEnum;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class DepositState implements ATMState {

    @Override
    public void DepositAmount(ATM atm, Map<NoteTypeEnum, Integer> amount) {
        AtomicInteger sum = new AtomicInteger(0);
        amount.keySet().stream().forEach(x -> sum.addAndGet(amount.get(x) * x.getValue()));
        atm.getCard().getBankAccount().setBankBalance(atm.getCard().getBankAccount().getBankBalance() + sum.get());
        for (NoteTypeEnum note : amount.keySet()) {
            atm.addMoney(note, amount.get(note));
        }
        atm.setState(new ReturnState());
        System.out.println("your current account balance is " + atm.getCard().getBankAccount().getBankBalance());
    }


}
