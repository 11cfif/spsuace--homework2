package ru.spsuace.homework2.collections.mail;

import java.util.Objects;

public class PaymentLetter extends BaseMail {
    private double payment;

    public PaymentLetter(String sender, String receiver, double payment) {
        super(sender, receiver);
        this.payment = payment;
    }

    public double getPayment() {
        return payment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        PaymentLetter that = (PaymentLetter) o;
        return payment == that.payment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), payment);
    }
}
