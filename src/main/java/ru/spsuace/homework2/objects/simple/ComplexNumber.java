package ru.spsuace.homework2.objects.simple;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 * Плюс реализуйте любой метод (операцию) над комплексными числами (на ваш выбор)
 */
public class ComplexNumber {
    private final double real;
    private final double imag;

    public ComplexNumber(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    public double module() {
        return Math.abs(Math.pow(real, 2) + Math.pow(imag, 2));
    }

    public static ComplexNumber complexSum(ComplexNumber complexNumber1, ComplexNumber complexNumber2) {
        return new ComplexNumber(complexNumber1.real + complexNumber2.real, complexNumber1.imag + complexNumber2.imag);
    }
}