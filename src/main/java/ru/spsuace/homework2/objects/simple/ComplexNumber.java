package ru.spsuace.homework2.objects.simple;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 * Плюс реализуйте 2 любых метод (операций) над комплексными числами (на ваш выбор).
 * Одна опреация должна быть статической, другая - нет.
 */
public class ComplexNumber {
    private final double complex;
    private final double real;

    public ComplexNumber(double real, double complex) {
        this.complex = complex;
        this.real = real;
    }

    public double getReal() {
        return real;
    }

    public double getComplex() {
        return complex;
    }

    public int hashCode() {
        return this.hashCode();
    }

    public String toString() {
        if (this.complex < 0) {
            return this.real + "-" + Math.abs(this.complex) + "i";
        } else {
            return this.real + "+" + Math.abs(this.complex) + "i";
        }
    }

    public boolean equals(Object number) {
        if (number == null || getClass() != number.getClass()) {
            return false;
        }
        return (Math.abs(real - ((ComplexNumber) number).real) < 1e-5) && (Math.abs(complex - ((ComplexNumber) number).complex) < 1e-5);
    }

    public static ComplexNumber sum(ComplexNumber number1, ComplexNumber number2) {
        return new ComplexNumber(number1.real + number2.real, number1.complex + number2.complex);
    }

    public double module() {
        return Math.abs(Math.pow(real, 2) + Math.pow(complex, 2));
    }

}