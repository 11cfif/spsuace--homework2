package ru.spsuace.homework2.objects;

import java.util.Objects;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 */
public class ComplexNumber {
    private final double re;
    private final double im;
    ComplexNumber (double im, double re) {
        this.re = re;
        this.im = im;
    }

    public double getReal() {

        return re;
    }

    public double getImaginary() {
        return im;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumber that = (ComplexNumber) o;
        return Double.compare(that.re, re) == 0 &&
                Double.compare(that.im, im) == 0;
    }

    @Override
    public int hashCode() {
        return (int) Math.ceil(re + im) + Integer.parseInt(Double.toString(re).split("\\.")[1]) * 11 + Integer.parseInt(Double.toString(im).split("\\.")[0]) * 33;
    }

    @Override
    public String toString() {
        char mathSymbol;
        if (im > 0) {
            mathSymbol = '+';
        }
        else {
            mathSymbol = '-';
        }
        return Double.toString(re) + mathSymbol + Math.abs(im) + 'i';
    }


}
