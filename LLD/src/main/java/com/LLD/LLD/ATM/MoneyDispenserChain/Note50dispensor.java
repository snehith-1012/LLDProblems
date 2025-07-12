package com.LLD.LLD.ATM.MoneyDispenserChain;

import com.LLD.LLD.ATM.ATM;
import com.LLD.LLD.ATM.ATMState.ReturnState;
import com.LLD.LLD.ATM.NoteTypeEnum;
import com.LLD.LLD.VendingMachine.Note;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Note50dispensor extends MoneyDispenserChain {
    @Override
    public void withDrawMoney(ATM atm, int amount, Map<NoteTypeEnum, Integer> notes) throws Exception {
        if (canHandle(amount, 50)) {
            int noteCountInAtm = atm.getNotes().get(NoteTypeEnum.FIFTY);
            int notesNeedToBeRemovedFromAtm = Math.min(noteCountInAtm, amount / 50);
            notes.put(NoteTypeEnum.FIFTY, notesNeedToBeRemovedFromAtm);
            amount = amount - notesNeedToBeRemovedFromAtm * 50;
            if (amount == 0) {
                deductMoneyFromATMAndCard(atm, notes);
                atm.setState(new ReturnState());
            } else {
                throw new Exception("ATM cannot handle this amount");
            }
        } else {
            if (amount == 0) {
                deductMoneyFromATMAndCard(atm, notes);
                atm.setState(new ReturnState());
            } else {
                throw new Exception("ATM cannot handle this amount");
            }
        }
    }

    public void deductMoneyFromATMAndCard(ATM atm, Map<NoteTypeEnum, Integer> notes) {
        for (Map.Entry<NoteTypeEnum, Integer> entry : notes.entrySet()) {
            atm.removeMoney(entry.getKey(), entry.getValue());
        }
        AtomicInteger sum = new AtomicInteger(0);
        notes.keySet().stream().forEach(x -> sum.addAndGet(notes.get(x) * x.getValue()));
        atm.getCard().getBankAccount().setBankBalance(atm.getCard().getBankAccount().getBankBalance() - sum.get());
        System.out.println(sum.get() + " is deducted from your account, your curreent balance is " + atm.getCard().getBankAccount().getBankBalance());
    }
}
