package ru.spsuace.homework2.objects;

import java.util.Objects;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 */
public class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    public ComplexNumber getReciprocal() {
        double denominator = re * re + im * im;
        if (denominator != 0) {
            return new ComplexNumber(re / denominator, im / denominator);
        } else {
            throw new ArithmeticException("denominator = 0");
        }
    }

    public double abs() {
        return Math.sqrt(re * re + im * im);

    }

    @Override
    public String toString() {
        if (im >= 0) {
            return "Re = " + re + ", Im = i * " + im;
        } else {
            return "Re = " + re + ", Im = - i * " + Math.abs(im);
        }
    }

    @Override
    public boolean equals(Object complex) {
        if (complex instanceof ComplexNumber) {
            ComplexNumber com = (ComplexNumber) complex;
            return (re == com.re && im == com.im);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(re, im);
    }
}
