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
        return this.real;
    }

    public double getImaginary() {
        return this.imaginary;
    }

    public double module() {
        return Math.abs(Math.pow(this.real, 2) + Math.pow(this.imaginary, 2));
    }

    public double argument() {
        if (this.real == 0 && this.imaginary > 0) {
            return Math.PI / 2;
        } else if (this.real == 0 && this.imaginary <= 0) {
            return -Math.PI / 2;
        } else if (this.real > 0) {
            return Math.atan2(this.imaginary, this.real);
        } else if (this.imaginary >= 0) {
            return Math.PI + Math.atan2(this.imaginary, this.real);
        } else {
            return -Math.PI + Math.atan2(this.imaginary, this.real);
        }
    }

    @Override
    public String toString() {
        if (this.imaginary < 0) {
            return this.real + "-" + Math.abs(this.imaginary) + "i";
        } else {
            return this.real + "+" + Math.abs(this.imaginary) + "i";
        }
    }

    public boolean equals(ComplexNumber number) {
        return this.equals(number);
    }

    public int hashCode() {
        return this.hashCode();
    }
}