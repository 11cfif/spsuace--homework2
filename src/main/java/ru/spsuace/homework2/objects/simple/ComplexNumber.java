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

    public String toString() {

        if (real != 0) {
            if (im > 0) {
                return real + "+" + im + "i";
            } else if (im == 0) {
                return String.valueOf(real);
            } else if (im < 0) {
                return real + "-" + Math.abs(im) + "i";
            }
        } else {
            if (im > 0) {
                return im + "i";
            } else if (im == 0) {
                return "0";
            } else if (im < 0) {
                return "-" + Math.abs(im) + "i";
            }
        }
        return null;
    }
}