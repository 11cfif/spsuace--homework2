package ru.spsuace.homework2.objects.simple;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 * Плюс реализуйте 2 любых метод (операций) над комплексными числами (на ваш выбор).
 * Одна опреация должна быть статической, другая - нет.
 */
public class ComplexNumber {
    private int complex;
    private int real;

    public ComplexNumber(int valid, int complex) {
        this.complex = complex;
        this.real = valid;
    }

    public int getValid() {
        return real;
    }

    public int getComplex() {
        return complex;
    }

    public void setComplex(int complex) {
        this.complex = complex;
    }

    public void setValid(int valid) {
        this.real = valid;
    }

    public String toString() {
        return this.real + this.complex + "*i";
    }

    public boolean equals(ComplexNumber number) {
        return (this.complex == number.complex) & (this.real == number.real);
    }

    public static ComplexNumber sum(ComplexNumber number1, ComplexNumber number2) {
        ComplexNumber number = new ComplexNumber(number1.real + number2.real, number1.complex + number2.complex);
        return number;
    }

    public double module() {
        return Math.abs(Math.pow(real, 2) + Math.pow(complex, 2));
    }

}