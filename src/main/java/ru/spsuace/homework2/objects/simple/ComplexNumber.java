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
    private final int imagine;
    private final int real;

    public ComplexNumber(int real, int imagine) {
        this.imagine = imagine;
        this.real = real;
    }

    public int getReal() {
        return real;
    }

    public int getImagine() {
        return imagine;
    }

    public String toString() {
        return real + imagine + "*i";
    }

    public boolean equals(ComplexNumber number) {
        return (this.imagine == number.imagine) & (this.real == number.real);
    }

    public static ComplexNumber sum(ComplexNumber number1, ComplexNumber number2) {
        ComplexNumber number = new ComplexNumber(number1.real + number2.real, number1.imagine + number2.imagine);
        return number;
    }

    public ComplexNumber compos(ComplexNumber number1, ComplexNumber number2) {
        ComplexNumber newNumber = new ComplexNumber(number1.getReal() * number2.getReal() - number1.getImagine() * number2.getImagine(), number1.getReal() * number2.getImagine() + number1.getImagine() * number2.getReal());
        return newNumber;
    }
}