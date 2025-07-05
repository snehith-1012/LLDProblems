package com.LLD.LLD.Swiggy.Coupons;

public class RupayCreditCard12PercentOffCoupon extends OrderCouponDecorator {
    public RupayCreditCard12PercentOffCoupon(Coupon coupon) {
        super(coupon);
    }

    @Override
    public int getDiscountedPrice(int originalPrice) {
        int price = originalPrice - (originalPrice * 12 / 100);
        return coupon.getDiscountedPrice(price);
    }
}
