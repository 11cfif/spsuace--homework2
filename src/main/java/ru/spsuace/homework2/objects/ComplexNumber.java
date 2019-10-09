package ru.spsuace.homework2.objects;

import java.util.Objects;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 * Плюс реализуйте любой метод (операцию) над комплексными числами (на ваш выбор)
 */

public class ComplexNumber {

    private final double real;
    private final double imaginary;

    public ComplexNumber(double real, double complex) {
        this.real = real;
        this.imaginary = complex;
    }

    public double getReal() {
        return real;
    }

    public double getComplex() {
        return imaginary;
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
        return that.real == real && that.imaginary == imaginary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(real, imaginary);
    }

    @Override
    public String toString() {
        if (this.imaginary > 0) {
            return real + " + " + imaginary + "i ";
        } else {
            return real + " - " + Math.abs(imaginary) + "i ";
        }
    }

    public static void main(String[] arg) {
        System.out.println(new ComplexNumber(18,32));
    }
}
