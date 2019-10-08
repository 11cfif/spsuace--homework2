package ru.spsuace.homework2.objects;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 * Плюс реализуйте любой метод (операцию) над комплексными числами (на ваш выбор)
 */
public class ComplexNumber {

    private final double real;
    private final double im;

    public ComplexNumber(double real, double im) {
        this.real=real;
        this.im=im;
    }

    public ComplexNumber(ComplexNumber z) {

        this(z.real, z.im);
    }

    public double getReal() {
        return real;
    }

    public double getIm() {
        return im;
    }

    public ComplexNumber getZ() {
        return new ComplexNumber(real,im);
    }

    @Override

    public String toString() {
            return "Комплексное число: " + real + " " + im;
    }
}
