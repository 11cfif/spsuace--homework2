package ru.spsuace.homework2.objects.simple;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 * Плюс реализуйте 2 любых метод (операций) над комплексными числами (на ваш выбор).
 * Одна опреация должна быть статической, другая - нет.
 */
public class ComplexNumber {

    private final double real;
    private final double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public double module() {
        return Math.abs(Math.pow(real, 2) + Math.pow(imaginary, 2));
    }

    public double argument() {
        if (this.real == 0 && imaginary > 0) {
            return Math.PI / 2;
        } else if (real == 0 && imaginary <= 0) {
            return -Math.PI / 2;
        } else if (real > 0) {
            return Math.atan2(imaginary, real);
        } else if (imaginary >= 0) {
            return Math.PI + Math.atan2(imaginary, real);
        } else {
            return -Math.PI + Math.atan2(imaginary, real);
        }
    }

    @Override
    public String toString() {
        if (imaginary < 0) {
            return real + "-" + Math.abs(imaginary) + "i";
        } else {
            return real + "+" + Math.abs(imaginary) + "i";
        }
    }

    public boolean equals(Object number, Double eps) {
        if (number == null || getClass() != number.getClass()) {
            return false;
        }
        return (Math.abs(real - ((ComplexNumber) number).real) < eps) && (Math.abs(imaginary - ((ComplexNumber) number).imaginary) < eps);
    }


    public int hashCode() {
        return this.hashCode();
    }
}