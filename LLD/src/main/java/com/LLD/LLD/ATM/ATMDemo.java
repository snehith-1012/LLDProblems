package com.LLD.LLD.ATM;

import com.LLD.LLD.ATM.ATMState.IdleState;

import java.util.HashMap;
import java.util.Map;

public class ATMDemo {

    public static void main(String[] args) {


        Map<NoteTypeEnum, Integer> notes = new HashMap<>();
        notes.put(NoteTypeEnum.FIFTY, 1);
        notes.put(NoteTypeEnum.ONE_HUNDRED, 1);
        notes.put(NoteTypeEnum.TWO_HUNDRED, 1);
        notes.put(NoteTypeEnum.FIVE_HUNDRED, 1);
        notes.put(NoteTypeEnum.TWO_THOUSAND, 1);


        Card card = new Card("card123", "sne", "12/12/12", "123", 345, new BankAccount("HdfcBank", 5000));
        ATM atm = ATM.getInstance(notes, new IdleState(), card);

        // this should fail
        atm.getState().checkBalance(atm);

        atm.getState().insertCard(card, atm);
        atm.getState().enterPin(atm, 345);
        atm.getState().selectTransactionType(atm, TransactionTypeEnum.SHOW_BALANCE);
        atm.getState().checkBalance(atm);
        atm.getState().collectCard(atm);


        atm.getState().insertCard(card, atm);
        atm.getState().enterPin(atm, 345);
        atm.getState().selectTransactionType(atm, TransactionTypeEnum.WITHDRAW);
        // this will fail
        atm.getState().checkBalance(atm);
        atm.getState().WithdrawMoneyFromATM(atm, 7000);
        atm.getState().WithdrawMoneyFromATM(atm, 4500);
        atm.getState().WithdrawMoneyFromATM(atm, 2000);
        atm.getState().collectCard(atm);

        atm.getState().insertCard(card, atm);
        atm.getState().enterPin(atm, 345);
        atm.getState().selectTransactionType(atm, TransactionTypeEnum.DEPOSIT);
        // this will fail
        atm.getState().WithdrawMoneyFromATM(atm, 5000);
        Map<NoteTypeEnum, Integer> depositAmount = new HashMap<>();
        depositAmount.put(NoteTypeEnum.TWO_THOUSAND, 1);
        atm.getState().DepositAmount(atm, depositAmount);
        atm.getState().collectCard(atm);


        atm.addMoney(NoteTypeEnum.TWO_THOUSAND, 2);

        atm.getState().insertCard(card, atm);
        atm.getState().enterPin(atm, 345);
        atm.getState().selectTransactionType(atm, TransactionTypeEnum.WITHDRAW);
        atm.getState().WithdrawMoneyFromATM(atm, 4500);
        atm.getState().collectCard(atm);


    }
}
