package com.LLD.LLD.ATM.MoneyDispenserChain;

import com.LLD.LLD.ATM.ATM;
import com.LLD.LLD.ATM.NoteTypeEnum;

import java.util.Map;

public class Note500Dispensor extends MoneyDispenserChain {
    @Override
    public void withDrawMoney(ATM atm, int amount, Map<NoteTypeEnum, Integer> notes) throws Exception {
        if (canHandle(amount, 500)) {
            int noteCountInAtm = atm.getNotes().get(NoteTypeEnum.FIVE_HUNDRED);
            int notesNeedToBeRemovedFromAtm = Math.min(noteCountInAtm, amount / 500);
            notes.put(NoteTypeEnum.FIVE_HUNDRED, notesNeedToBeRemovedFromAtm);
            amount = amount - notesNeedToBeRemovedFromAtm * 500;
            this.getNextMoneyDispenser().withDrawMoney(atm, amount, notes);
        } else {
            this.getNextMoneyDispenser().withDrawMoney(atm, amount, notes);
        }
    }
}
