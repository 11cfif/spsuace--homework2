package ru.spsuace.homework2.objects;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 */
public class ComplexNumber {
    public double re;
    public double im;

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
            return new ComplexNumber(re / denominator, -im / denominator);
        } else {
            throw new ArithmeticException("denominator = 0");
        }

    }public double abs() {
        return Math.sqrt(re * re + im * im);
    }

    @Override
    public String toString() {
        return "Re = " + re + ", Im = " + im;
    }
}
