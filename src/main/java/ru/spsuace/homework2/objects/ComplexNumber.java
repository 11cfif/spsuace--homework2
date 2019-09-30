package ru.spsuace.homework2.objects;

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

    public double argument(){
        if (real == 0 && imaginary > 0) {
            return Math.PI / 2;
        } else if (real == 0 && imaginary <= 0) {
            return -Math.PI / 2;
        } else if (real > 0) {
            return Math.atan2(imaginary, real);
        } else if (imaginary >= 0) {
            return Math.PI + Math.atan2(imaginary, real);
        } else {
            return -Math.PI + Math.atan2(imaginary, real);
        }
    }

    @Override
    public String toString() {
        if (imaginary < 0) {
            return real + "-" + Math.abs(imaginary) + "i";
        } else {
            return real + "+" + Math.abs(imaginary) + "i";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else {
            return this == o;
        }
    }

    public int hashCode(){
        final int prime = 17;
        double result = 1;
        result = (prime * result + real);
        result = (prime * result + imaginary);
        return (int) result;
    }


}
