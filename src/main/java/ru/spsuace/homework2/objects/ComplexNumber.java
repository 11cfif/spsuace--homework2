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

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return this.real;
    }

    public double getImaginary() {
        return this.imaginary;
    }

    @Override
    public String toString() {
        double sign;
        if (imaginary > 0) {
            sign = '+';
        } else {
            sign = '-';
        }
        return "" + real + sign + Math.abs(imaginary) + 'i';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        double result = 1;
        result = prime * result + real;
        result = prime * result + imaginary;
        return (int) result;
    }

    public boolean equals(Object o) {
        if (o instanceof ComplexNumber) {
            ComplexNumber num = (ComplexNumber)o;
            return ((Math.abs(this.imaginary - num.imaginary) < 1e-4) && (Math.abs(this.real - num.real) < 1e-4));
        }
        return false;
    }
}
