package com.LLD.LLD.ATM.MoneyDispenserChain;

import com.LLD.LLD.ATM.ATM;
import com.LLD.LLD.ATM.NoteTypeEnum;

import java.util.Map;

public class Note2000Dispensor extends MoneyDispenserChain {
    @Override
    public void withDrawMoney(ATM atm, int amount, Map<NoteTypeEnum, Integer> notes) throws Exception {
        if (canHandle(amount, 2000)) {
            int noteCountInAtm = atm.getNotes().get(NoteTypeEnum.TWO_THOUSAND);
            int notesNeedToBeRemovedFromAtm = Math.min(noteCountInAtm, amount/2000);
            notes.put(NoteTypeEnum.TWO_THOUSAND, notesNeedToBeRemovedFromAtm);
            amount = amount - notesNeedToBeRemovedFromAtm * 2000;
            this.getNextMoneyDispenser().withDrawMoney(atm, amount, notes);
        } else {
            this.getNextMoneyDispenser().withDrawMoney(atm, amount, notes);
        }
    }
}
