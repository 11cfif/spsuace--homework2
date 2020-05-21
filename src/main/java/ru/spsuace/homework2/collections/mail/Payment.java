package ru.spsuace.homework2.collections.mail;

public class Payment extends BaseMail {
    private double salary;

    public Payment(String sender, String recipient, double salary) {
        super(sender, recipient);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
