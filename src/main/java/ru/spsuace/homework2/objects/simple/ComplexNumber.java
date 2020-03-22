package ru.spsuace.homework2.objects.simple;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 * Плюс реализуйте 2 любых метод (операций) над комплексными числами (на ваш выбор).
 * Одна опреация должна быть статической, другая - нет.
 */

public class ComplexNumber {
    private final double im;
    private final double re;

    public ComplexNumber(double re, double im) {
        this.im = im;
        this.re = re;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    public double getModule() {
        return Math.sqrt(Math.pow(this.re, 2) + Math.pow(this.im, 2));
    }

    public static ComplexNumber sum(ComplexNumber z1, ComplexNumber z2) {
        return new ComplexNumber(z1.getRe() + z2.getRe(), z1.getIm() + z2.getIm());
    }

    public double getArg() {
        if (this.re > 0) {
            return Math.atan(im / re);
        } else {
            if (re < 0 && im > 0) {
                return Math.PI + Math.atan(im / re);
            } else {
                return -Math.PI + Math.atan(im / re);
            }
        }
    }

    public static ComplexNumber pow(ComplexNumber z, int power) {
        double factor = Math.pow(z.getModule(), power);
        return new ComplexNumber(factor * Math.cos(power * z.getArg()), factor * Math.sin(power * z.getArg()));
    }

    public String toString() {
        if (im < 0) {
            return re + "-" + Math.abs(im) + "i";
        } else {
            return re + "+" + im + "i";
        }
    }

    public boolean equals(Object number) {
        if (getClass() != number.getClass()) {
            return false;
        }
        return this.re == ((ComplexNumber) number).re && this.im == ((ComplexNumber) number).im;
    }
}