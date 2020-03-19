package ru.spsuace.homework2.objects.simple;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
     * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 * Плюс реализуйте любой метод (операцию) над комплексными числами (на ваш выбор)
 */
public class ComplexNumber {
    private final double real;
    private final double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal(){
        return real;
    }

    public double getImaginary(){
        return imaginary;
    }

    public double module(){
        return Math.abs(Math.pow(real, 2) + Math.pow(imaginary, 2));
    }
}
