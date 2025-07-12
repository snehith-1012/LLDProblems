package com.LLD.LLD.ATM.ATMState;

import com.LLD.LLD.ATM.ATM;
import com.LLD.LLD.ATM.Card;

public class IdleState implements ATMState{

    @Override
    public void insertCard(Card card, ATM atm) {
        atm.setCard(card);
        atm.setState(new InsertCardState());
    }
}
