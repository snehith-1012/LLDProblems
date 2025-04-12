package com.LLD.LLD.VendingMachine;

public enum Coin {
    PENNY(0.01),
    NICKEL(0.05),
    DIME(0.1),
    QUARTER(0.25);

    private final double val;

    Coin(double val){
        this.val = val;
    }

    public double getVal(){
        return this.val;
    }

}
