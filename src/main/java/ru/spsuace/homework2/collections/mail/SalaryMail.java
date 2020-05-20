package ru.spsuace.homework2.collections.mail;

public class SalaryMail extends BaseMail {
    private final double salary;

    public SalaryMail(String recipient, String sender, double salary) {
        super(recipient, sender);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}
