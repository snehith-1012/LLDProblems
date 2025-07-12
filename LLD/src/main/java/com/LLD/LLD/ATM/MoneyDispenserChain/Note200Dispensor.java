package com.LLD.LLD.ATM.MoneyDispenserChain;

import com.LLD.LLD.ATM.ATM;
import com.LLD.LLD.ATM.NoteTypeEnum;

import java.util.Map;

public class Note200Dispensor extends MoneyDispenserChain {
    @Override
    public void withDrawMoney(ATM atm, int amount, Map<NoteTypeEnum, Integer> notes) throws Exception {
        if (canHandle(amount, 200)) {
            int noteCountInAtm = atm.getNotes().get(NoteTypeEnum.TWO_HUNDRED);
            int notesNeedToBeRemovedFromAtm = Math.min(noteCountInAtm, amount / 200);
            notes.put(NoteTypeEnum.TWO_HUNDRED, notesNeedToBeRemovedFromAtm);
            amount = amount - notesNeedToBeRemovedFromAtm * 200;
            this.getNextMoneyDispenser().withDrawMoney(atm, amount, notes);
        } else {
            this.getNextMoneyDispenser().withDrawMoney(atm, amount, notes);
        }
    }
}
