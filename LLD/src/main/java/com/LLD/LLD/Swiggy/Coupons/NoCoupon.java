package com.LLD.LLD.Swiggy.Coupons;

public class NoCoupon implements Coupon{

    private int originalPrice ;
    @Override
    public int getDiscountedPrice(int originalPrice) {;
        this.originalPrice = originalPrice;
        return originalPrice;
    }
}
