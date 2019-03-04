package ru.spsuace.homework2.objects;

import java.util.Objects;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 */
public final class ComplexNumber {
    private final double real;
    private final double imaginary;

    public ComplexNumber (double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public String toString() {
        return real + " + " + imaginary + "i";
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof ComplexNumber) {
            ComplexNumber number = (ComplexNumber)obj;
            return  (real == number.real) && (imaginary == number.imaginary);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(real, imaginary);
    }
}
