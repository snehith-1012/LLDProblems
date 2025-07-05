package com.LLD.LLD.Swiggy.Coupons;

public abstract class OrderCouponDecorator implements Coupon {

    protected Coupon coupon;

    public OrderCouponDecorator(Coupon coupon) {
        this.coupon = coupon;
    }

    @Override
    public int getDiscountedPrice(int originalPrice) {
        return 0;
    }
}
