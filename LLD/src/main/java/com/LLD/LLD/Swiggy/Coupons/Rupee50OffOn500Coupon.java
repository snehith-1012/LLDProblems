package com.LLD.LLD.Swiggy.Coupons;

public class Rupee50OffOn500Coupon extends OrderCouponDecorator {
    public Rupee50OffOn500Coupon(Coupon coupon) {
        super(coupon);
    }

    @Override
    public int getDiscountedPrice(int originalPrice) {
        if (originalPrice > 500) {
            return originalPrice - 50;
        } else {
            return originalPrice;
        }
    }
}
