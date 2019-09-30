package ru.spsuace.homework2.objects;

import java.util.Objects;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 * Плюс реализуйте любой метод (операцию) над комплексными числами (на ваш выбор)
 */
public class ComplexNumber {
    private final double supposed;
    private final double real;

    public ComplexNumber(double supposed, double real) {
        this.supposed = supposed;
        this.real = real;
    }

    public double getSupposed() {
        return supposed;
    }

    public double getReal() {
        return real;
    }

    @Override
    public String toString() {
        return "ComplexNumber{" +
                "i" + supposed +
                ", Re=" + real +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(supposed, real);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ComplexNumber that = (ComplexNumber) o;
        return Double.compare(that.supposed, supposed) == 0 &&
                Double.compare(that.real, real) == 0;
    }
}
