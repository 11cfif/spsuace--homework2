package ru.spsuace.homework2.collections.mail;


public class SalaryMail extends BaseMail {
    private final int salary;

    public SalaryMail(String sender, String recipient, int text) {
        super(sender, recipient);
        this.salary = text;
    }

    public int getSalary() {
        return salary;
    }

}
