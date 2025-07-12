package com.LLD.LLD.ATM.ATMState;

import com.LLD.LLD.ATM.ATM;
import com.LLD.LLD.ATM.MoneyDispenserChain.*;

import java.util.HashMap;

public class WithDrawState implements ATMState {

    public MoneyDispenserChain getChain() {
        Note50dispensor note50Dispensor = new Note50dispensor();
        Note100Dispensor note100Dispensor = new Note100Dispensor();
        Note200Dispensor note200Dispensor = new Note200Dispensor();
        Note500Dispensor note500Dispensor = new Note500Dispensor();
        Note2000Dispensor note2000Dispensor = new Note2000Dispensor();

        note50Dispensor.setNextMoneyDispenser(null);
        note100Dispensor.setNextMoneyDispenser(note50Dispensor);
        note200Dispensor.setNextMoneyDispenser(note100Dispensor);
        note500Dispensor.setNextMoneyDispenser(note200Dispensor);
        note2000Dispensor.setNextMoneyDispenser(note500Dispensor);
        return note2000Dispensor;
    }

    public void WithdrawMoneyFromATM(ATM atm, Integer amount) {
        MoneyDispenserChain dispenserChain = getChain();
        try {
            if (amount > atm.getCard().getBankAccount().getBankBalance()) {
                System.out.println("Insufficient balance");
            } else {
                dispenserChain.withDrawMoney(atm, amount, new HashMap<>());
            }
        } catch (Exception e) {
            if (e.getMessage().equals("ATM cannot handle this amount")) {
                System.out.println("ATM cannot handle this amount, choose a different amount");
            }
        }
    }
}
