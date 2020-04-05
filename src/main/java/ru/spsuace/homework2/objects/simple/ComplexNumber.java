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
        if (real < 0) {
            if (im < 0) {
                return real + String.valueOf(im) + "i";
            } else if (im > 0) {
                return "-" + real + "+" + im + "i";
            } else {
                return String.valueOf(real);
            }
        } else if (real > 0) {
            if (im > 0) {
                return real + "+" + im + "i";
            } else if (im == 0) {
                return String.valueOf(real);
            } else {
                return real + String.valueOf(im) + "i";
            }
        } else {
            if (im > 0) {
                return im + "i";
            } else if (im < 0) {
                return im + "i";
            } else {
                return "0";
            }
        }
    }

    public static ComplexNumber complexMult(ComplexNumber numb1, ComplexNumber numb2) {
        return new ComplexNumber((numb1.real * numb2.real) - (numb1.im * numb2.im), (numb1.real * numb2.im) + (numb1.im * numb2.real));
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return (Math.abs(this.real - ((ComplexNumber) o).real) == 1e-5 || Math.abs(this.im - ((ComplexNumber) o).im) == 1e-5);
    }

    public double vector() {
        return Math.abs(Math.pow(real, 2) + Math.pow(im, 2));
    }
}