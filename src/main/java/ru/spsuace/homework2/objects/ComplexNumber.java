package ru.spsuace.homework2.objects;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 */
public class ComplexNumber {

    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.im = im;
        this.re = re;
    }

    public double getReal() {
        return this.re;
    }

    public double getImaginary() {
        return this.im;
    }

    public double modulus() {
        return Math.abs(this.im * this.im + this.re * this.re);
    }

    public double argument() {
        return (this.modulus() == 0) ? 0 : Math.atan2(this.im, this.re);
    }
    public String toString() {
        if (this.im >= 0) {
            return this.re + " + i * " + this.im;
        } else {
            return this.re + " - i * " + Math.abs(this.im);
        }
    }

    public boolean equals(ComplexNumber num) {
        return ((Math.abs(this.re - num.re) < 1e-4) && (Math.abs(this.im - num.im) < 1e-4));
    }

    public int hashCode() {
        return (int) (1000 * this.modulus() * this.argument());
    }
}
