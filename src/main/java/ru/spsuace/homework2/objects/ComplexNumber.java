package ru.spsuace.homework2.objects;

import java.util.Objects;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 */
public final class ComplexNumber {
    private double real = 0.0;
    private double imaginary = 0.0;

    public ComplexNumber (double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public final double getReal() {
        return real;
    }

    public final double getImaginary() {
        return imaginary;
    }

    public final String toString() {

        if (this.imaginary > 0) {
            return real + " + " + imaginary + "i";
        }

        return real + " + " + "i";
    }

    @Override
    public final boolean equals(Object obj) {

        if (obj instanceof ComplexNumber) {
            ComplexNumber number = (ComplexNumber)obj;
            return  (real == number.real) && (imaginary == number.imaginary);
        }

        return false;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(real, imaginary);
    }
}
