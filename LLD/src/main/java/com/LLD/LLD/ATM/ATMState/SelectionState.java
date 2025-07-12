package com.LLD.LLD.ATM.ATMState;


import com.LLD.LLD.ATM.ATM;
import com.LLD.LLD.ATM.TransactionFactory.TransactionFactory;
import com.LLD.LLD.ATM.TransactionTypeEnum;

public class SelectionState implements ATMState {


    public void selectTransactionType(ATM atm, TransactionTypeEnum transactionTypeEnum) {
        atm.setState(TransactionFactory.getATMState(transactionTypeEnum));
    }
}
