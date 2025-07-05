package com.LLD.LLD.BookMyShow.PaymentStratergy;

import com.LLD.LLD.BookMyShow.Enum.PaymentTypeEnum;
import com.LLD.LLD.Swiggy.Stratergy.UpiPaymentStratergy;

public class PaymentFactory {

    public static PaymentStratergy getPaymentStratergy(PaymentTypeEnum paymentTypeEnum) {

        switch (paymentTypeEnum) {
            case UPI:
                return new UPIpayment();
            case CREDIT_CARD:
                return new CreditCardPayment();
            default:
                throw new IllegalArgumentException("Invalid payment type");
        }
    }
}
