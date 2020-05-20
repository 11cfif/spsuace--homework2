package ru.spsuace.homework2.collections.mail;

import java.util.Objects;

public class SalaryMail extends BaseMail {
    private int salary;

    public SalaryMail(String sender, String recipient, int salary) {
        super(sender, recipient);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
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
        SalaryMail that = (SalaryMail) o;
        return salary == that.salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salary);
    }
}
