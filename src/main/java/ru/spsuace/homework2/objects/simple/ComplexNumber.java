package ru.spsuace.homework2.objects.simple;

import java.util.Objects;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 * Плюс реализуйте любой метод (операцию) над комплексными числами (на ваш выбор)
 */
public class ComplexNumber {
    private final double real;
    private final double im;

    public ComplexNumber(double real, double im) {
        this.real = real;
        this.im = im;
    }

    public double getReal() {
        return real;
    }

    public double getIm() {
        return im;
    }


    public static ComplexNumber sum(ComplexNumber c1, ComplexNumber c2) {
        return new ComplexNumber(c1.getReal() + c2.getReal(), c1.getIm() + c2.getIm());
    }

    public ComplexNumber multiply(ComplexNumber cn1) {
        return new ComplexNumber(cn1.getReal() * getReal() - cn1.getIm() * getIm(), cn1.getReal() * getIm() + cn1.getIm() * getReal());
    }

    public String toString() {
        if (getIm() < 0) {
            return getReal() + "-i*" + getIm() * -1;
        } else {
            return getReal() + "+i*" + getIm();
        }
    }
}