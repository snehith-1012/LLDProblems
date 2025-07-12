package com.LLD.LLD.ATM.TransactionFactory;

import com.LLD.LLD.ATM.ATMState.*;
import com.LLD.LLD.ATM.TransactionTypeEnum;

public class TransactionFactory {

    public static ATMState getATMState(TransactionTypeEnum transactionTypeEnum) {
        if (transactionTypeEnum == TransactionTypeEnum.SHOW_BALANCE) {
            return new ShowBalanceState();
        } else if (transactionTypeEnum == TransactionTypeEnum.DEPOSIT) {
            return new DepositState();
        } else {
            return new WithDrawState();
        }
    }
}
