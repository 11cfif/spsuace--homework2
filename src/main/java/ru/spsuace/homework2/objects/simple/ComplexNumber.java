package ru.spsuace.homework2.objects.simple;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 * Плюс реализуйте 2 любых метод (операций) над комплексными числами (на ваш выбор).
 * Одна опреация должна быть статической, другая - нет.
 */
public class ComplexNumber {
    private final double comp;
    private final double real;

    public ComplexNumber(double real, double comp) {
        this.comp = comp;
        this.real = real;
    }

    public double getComp() {
        return comp;
    }

    public double getReal() {
        return real;
    }


    public String toString() {
        return real + " " + comp + "*i";
    }

    public boolean equals(Object num) {
        if (getClass() != num.getClass()) {
            return false;
        }
        return this.real == ((ComplexNumber) num).real && this.comp == ((ComplexNumber) num).comp;
    }

    public static ComplexNumber sum(ComplexNumber num1, ComplexNumber num2) {
        return new ComplexNumber(num1.real + num2.real, num1.comp + num2.comp);
    }

    public ComplexNumber multiplier(ComplexNumber num) {
        return new ComplexNumber(num.real * real - num.comp * comp, num.real * comp + num.comp * real);
    }

}