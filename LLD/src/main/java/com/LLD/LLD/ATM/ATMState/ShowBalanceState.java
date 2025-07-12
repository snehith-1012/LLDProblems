package com.LLD.LLD.ATM.ATMState;

import com.LLD.LLD.ATM.ATM;

public class ShowBalanceState implements ATMState {

    @Override
    public void checkBalance(ATM atm) {
        System.out.println("your balance is " + atm.getCard().getBankAccount().getBankBalance());
        atm.setState(new ReturnState());
    }
}
