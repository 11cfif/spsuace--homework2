package ru.spsuace.homework2.objects.simple;

import com.sun.javafx.css.Combinator;

import static com.sun.tools.doclint.Entity.and;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 * Плюс реализуйте 2 любых метод (операций) над комплексными числами (на ваш выбор).
 * Одна опреация должна быть статической, другая - нет.
 */
public class ComplexNumber {
    private final double imagine;
    private final double real;

    public ComplexNumber(double real, double imagine) {
        this.imagine = imagine;
        this.real = real;
    }

    public double getReal() {
        return real;
    }

    public double getImagine() {
        return imagine;
    }

    public String toString() {
        return real + " " + imagine + "*i";
    }

    public boolean equals(Object number) {
        if (getClass() != number.getClass()) {
            return false;
        }
        return this.real == ((ComplexNumber) number).real && this.imagine == ((ComplexNumber) number).imagine;
    }

    public static ComplexNumber sum(ComplexNumber number1, ComplexNumber number2) {
        return new ComplexNumber(number1.real + number2.real, number1.imagine + number2.imagine);
    }

    public ComplexNumber compos(ComplexNumber number1, ComplexNumber number2) {
        return new ComplexNumber(number1.getReal() * number2.getReal() - number1.getImagine() * number2.getImagine(), number1.getReal() * number2.getImagine() + number1.getImagine() * number2.getReal());
    }
}