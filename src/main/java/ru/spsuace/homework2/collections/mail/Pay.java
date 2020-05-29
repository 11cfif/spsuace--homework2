package ru.spsuace.homework2.collections.mail;

public class Pay extends BaseMail {
    private final double pay;

    public Pay(String Destination, String Departure, double pay) {
        super(Destination, Departure);
        this.pay = pay;
    }

    public double getSalary() {
        return pay;
    }
}
