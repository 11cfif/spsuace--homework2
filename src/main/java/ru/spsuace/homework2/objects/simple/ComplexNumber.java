package ru.spsuace.homework2.objects.simple;

import java.util.Objects;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 * Плюс реализуйте 2 любых метод (операций) над комплексными числами (на ваш выбор).
 * Одна опреация должна быть статической, другая - нет.
 */
public class ComplexNumber {
    private final double a;
    private final double b;

    public ComplexNumber(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public ComplexNumber sum(ComplexNumber complexNumber) {
        if (complexNumber == null) {
            return null;
        }

        return new ComplexNumber(a + complexNumber.getA(), b + complexNumber.getB());
    }

    public static ComplexNumber multiply(ComplexNumber complexNumber1, ComplexNumber complexNumber2) {
        if (complexNumber1 == null || complexNumber2 == null) {
            return null;
        }

        double a = complexNumber1.getA() * complexNumber2.getA() - complexNumber1.getB() * complexNumber2.getB();
        double b = complexNumber1.getA() * complexNumber2.getB() + complexNumber2.getA() * complexNumber1.getB();

        return new ComplexNumber(a, b);
    }

    @Override
    public String toString() {

        if (a == 0) {
            return b + "i";
        } else if (b == 0) {
            return a + "";
        } else if (b < 0) {
            return a + "" + b + " i ";
        }

        return a + " + " + b + "i";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumber that = (ComplexNumber) o;
        return Double.compare(that.a, a) == 0 &&
                Double.compare(that.b, b) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}

