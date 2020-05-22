package ru.spsuace.homework2.collections.mail;

public class PayPay extends BaseMail {
    private final double pay;

    public PayPay(String Destination, String Departure, double pay) {
        super(Destination, Departure);
        this.pay = pay;
    }

    public double getSalary() {
        return pay;
    }
}

