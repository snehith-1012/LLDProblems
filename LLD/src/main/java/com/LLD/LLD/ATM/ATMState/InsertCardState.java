package com.LLD.LLD.ATM.ATMState;

import com.LLD.LLD.ATM.ATM;

public class InsertCardState implements ATMState{

    @Override
    public void enterPin(ATM atm, Integer pin) {
        if(atm.getCard().getPin().equals( pin)){
            atm.setState(new SelectionState());
        } else {
            System.out.println("Invalid Pin");
        }
    }
}
