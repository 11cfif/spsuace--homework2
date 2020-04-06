package ru.spsuace.homework2.objects.simple;

import java.util.Objects;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 * Плюс реализуйте 2 любых метод (операций) над комплексными числами (на ваш выбор).
 * Одна опреация должна быть статической, другая - нет.
 */
public class ComplexNumber {
    private final double realPart;
    private final double imaginaryPart;

    public ComplexNumber(double a, double b) {
        this.realPart = a;
        this.imaginaryPart = b;
    }

    public double getRealPart() {
        return realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public ComplexNumber sum(ComplexNumber complexNumber) {
        if (complexNumber == null) {
            return null;
        }

        return new ComplexNumber(realPart + complexNumber.getRealPart(), imaginaryPart + complexNumber.getImaginaryPart());
    }

    public static ComplexNumber multiply(ComplexNumber complexNumber1, ComplexNumber complexNumber2) {
        if (complexNumber1 == null || complexNumber2 == null) {
            return null;
        }

        double a = complexNumber1.getRealPart() * complexNumber2.getRealPart() - complexNumber1.getImaginaryPart() * complexNumber2.getImaginaryPart();
        double b = complexNumber1.getRealPart() * complexNumber2.getImaginaryPart() + complexNumber2.getRealPart() * complexNumber1.getImaginaryPart();

        return new ComplexNumber(a, b);
    }

    @Override
    public String toString() {

        if (realPart == 0) {
            return imaginaryPart + "i";
        } else if (imaginaryPart == 0) {
            return realPart + "";
        } else if (imaginaryPart < 0) {
            return realPart + "" + imaginaryPart + " i ";
        }

        return realPart + " + " + imaginaryPart + "i";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumber that = (ComplexNumber) o;
        return Double.compare(that.realPart, realPart) == 0 &&
                Double.compare(that.imaginaryPart, imaginaryPart) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(realPart, imaginaryPart);
    }
}

