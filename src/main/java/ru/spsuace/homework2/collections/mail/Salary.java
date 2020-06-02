package ru.spsuace.homework2.collections.mail;

import java.util.Objects;

public class Salary extends BaseMail {
    private final int salary;

    public Salary(String sender, String receiver, int salary) {
        super(sender, receiver);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
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
        Salary that = (Salary) o;
        return salary == that.salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salary);
    }
}