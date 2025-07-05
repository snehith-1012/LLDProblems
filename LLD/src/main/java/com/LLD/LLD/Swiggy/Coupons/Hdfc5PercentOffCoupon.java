package com.LLD.LLD.Swiggy.Coupons;

public class Hdfc5PercentOffCoupon extends OrderCouponDecorator {
    public Hdfc5PercentOffCoupon(Coupon coupon) {
        super(coupon);
    }

    @Override
    public int getDiscountedPrice(int originalPrice) {
        int price = (int) (originalPrice * 0.95);
        return coupon.getDiscountedPrice(price);
    }
}
