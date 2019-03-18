package ru.spsuace.homework2.objects;

import java.util.Objects;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 */

public class ComplexNumber {
    private final double re; //real part
    private final double im; //imaginary part

    //конструктор
    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    //геттер Im
    public double getIm() {
        return im;
    }

    //геттер Re
    public double getRe() {
        return re;
    }

    //в string
    public String toString() {

        return re + " + i( " + im + ")";
    }

    //присваивание и сравнение
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        ComplexNumber coNum = (ComplexNumber) obj;
        return (re == coNum.re && im == coNum.im);

    }

    //HashCode для HashMap
    @Override
    public int hashCode() {
        return Objects.hash(re, im);
    }
}
