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
    private int imagine;
    private int valid;

    public ComplexNumber(int valid, int imagine) {
        this.imagine = imagine;
        this.valid = valid;
    }

    public int getValid() {
        return valid;
    }

    public int getImagine() {
        return imagine;
    }

    public void setImagine(int imagine) {
        this.imagine = imagine;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }

    public String toString() {
        return this.valid + this.imagine + "*i";
    }

    public boolean equals(ComplexNumber number) {
        return (this.imagine == number.imagine) & (this.valid == number.valid);
    }
    
    public static ComplexNumber sum(ComplexNumber number1, ComplexNumber number2) {
        ComplexNumber number = new ComplexNumber(number1.valid+number2.valid,  number1.imagine+number2.imagine);
        return number;
    }
    public ComplexNumber compos(ComplexNumber number1, ComplexNumber number2) {
        ComplexNumber newNumber = new ComplexNumber(0, 0);
        newNumber.setValid(number1.getValid() * number2.getValid() - number1.getImagine() * number2.getImagine());
        newNumber.setImagine(number1.getValid() * number2.getImagine() + number1.getImagine() * number2.getValid());
        return newNumber;
    }
}