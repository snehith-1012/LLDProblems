package com.LLD.LLD.ATM;

public class BankAccount {

    private String bankName;

    private Integer bankBalance;

    public BankAccount(String bankName, Integer bankBalance) {
        this.bankName = bankName;
        this.bankBalance = bankBalance;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Integer getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(Integer bankBalance) {
        this.bankBalance = bankBalance;
    }
}
