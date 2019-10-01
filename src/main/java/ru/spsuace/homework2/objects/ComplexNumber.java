package ru.spsuace.homework2.objects;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 * Плюс реализуйте любой метод (операцию) над комплексными числами (на ваш выбор)
 */
public class ComplexNumber {
    private double real;
    private double imaginary;
    private static final double eps = 0.000000001;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getImaginary() {
        return imaginary;
    }

    public double getReal() {
        return real;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        ComplexNumber complex = (ComplexNumber) obj;
        return doubleEqual(complex.getImaginary(), getImaginary()) && doubleEqual(complex.getReal(), getReal());
    }

    public static ComplexNumber sum(ComplexNumber a, ComplexNumber b) {
        return new ComplexNumber(a.getReal() + b.getReal(), a.getImaginary() + b.getImaginary());
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public String toString() {
        if (doubleEqual(getImaginary(), 0.0)) {
            return String.valueOf(getReal());
        }
        char sign;
        if (getReal() > 0.0) {
            sign = '+';
        } else {
            sign = '-';
        }
        return getReal() + sign + getImaginary() + "i";
    }

    private static boolean doubleEqual(double a, double b) {
        return Math.abs(a - b) < eps;
    }
}
