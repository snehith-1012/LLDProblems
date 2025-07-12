package com.LLD.LLD.ATM.ATMState;

import com.LLD.LLD.ATM.ATM;

public class ReturnState implements ATMState {

    @Override
    public void collectCard(ATM atm){
        System.out.println("please collect your card");
        atm.setCard(null);
        atm.setState(new IdleState());
    }
}
