package com.LLD.LLD.ATM.MoneyDispenserChain;

import com.LLD.LLD.ATM.ATM;
import com.LLD.LLD.ATM.NoteTypeEnum;

import java.util.Map;

public abstract class MoneyDispenserChain {

    private MoneyDispenserChain nextMoneyDispenser;

    public abstract void withDrawMoney(ATM atm, int amount, Map<NoteTypeEnum, Integer> notes) throws Exception;

    public MoneyDispenserChain getNextMoneyDispenser() {
        return nextMoneyDispenser;
    }

    public void setNextMoneyDispenser(MoneyDispenserChain nextMoneyDispenser) {
        this.nextMoneyDispenser = nextMoneyDispenser;
    }

    public boolean canHandle(int amount, int noteValue) {
        if (amount >= noteValue) {
            return true;
        } else {
            return false;
        }
    }

}
