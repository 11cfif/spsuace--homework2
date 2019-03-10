package ru.spsuace.homework2.objects;

import java.util.Objects;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 */
public class ComplexNumber {

    private final double realPart;
    private final double imaginaryPart;

    ComplexNumber(double pr, double ip) {
        this.realPart = pr;
        this.imaginaryPart = ip;
    }

    public double getRealPart() {
        return realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    @Override
    public String toString() {
        return realPart + " + " + imaginaryPart + 'i';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        ComplexNumber complexNumber = (ComplexNumber) obj;
        return (realPart == complexNumber.realPart && imaginaryPart == complexNumber.imaginaryPart);
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        double result = 1;
        result = prime * result + realPart;
        result = prime * result + imaginaryPart;
        return (int) result;
    }
}
