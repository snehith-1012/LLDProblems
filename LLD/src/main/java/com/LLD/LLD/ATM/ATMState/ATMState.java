package com.LLD.LLD.ATM.ATMState;

import com.LLD.LLD.ATM.ATM;
import com.LLD.LLD.ATM.Card;
import com.LLD.LLD.ATM.NoteTypeEnum;
import com.LLD.LLD.ATM.TransactionTypeEnum;

import java.util.Map;

public interface ATMState {

    // idle state
    default void insertCard(Card card, ATM atm) {
        System.out.println("you current state is invalid");
    }

    // insert card state
    default void enterPin(ATM atm, Integer pin) {
        System.out.println("you current state is invalid");
    }

    // selection state
    default void selectTransactionType(ATM atm, TransactionTypeEnum transactionTypeEnum) {
        System.out.println("you current state is invalid");
    }

    // Show Balance State
    default void checkBalance(ATM atm) {
        System.out.println("you current state is invalid");
    }

    // Deposit State
    default void DepositAmount(ATM atm, Map<NoteTypeEnum,Integer> amount) {
        System.out.println("you current state is invalid");
    }

    // withdraw State
    default void WithdrawMoneyFromATM(ATM atm, Integer amount) {
        System.out.println("you current state is invalid");
    }

    // return state
    default void collectCard(ATM atm){
        System.out.println("you current state is invalid");
    }
}
