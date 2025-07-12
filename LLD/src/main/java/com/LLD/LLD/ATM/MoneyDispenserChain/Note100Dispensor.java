package com.LLD.LLD.ATM.MoneyDispenserChain;

import com.LLD.LLD.ATM.ATM;
import com.LLD.LLD.ATM.NoteTypeEnum;

import java.util.Map;

public class Note100Dispensor extends MoneyDispenserChain {
    @Override
    public void withDrawMoney(ATM atm, int amount, Map<NoteTypeEnum, Integer> notes) throws Exception {
        if (canHandle(amount, 100)) {
            int noteCountInAtm = atm.getNotes().get(NoteTypeEnum.ONE_HUNDRED);
            int notesNeedToBeRemovedFromAtm = Math.min(noteCountInAtm, amount / 100);
            notes.put(NoteTypeEnum.ONE_HUNDRED, notesNeedToBeRemovedFromAtm);
            amount = amount - notesNeedToBeRemovedFromAtm * 100;
            this.getNextMoneyDispenser().withDrawMoney(atm, amount, notes);
        } else {
            this.getNextMoneyDispenser().withDrawMoney(atm, amount, notes);
        }
    }
}
