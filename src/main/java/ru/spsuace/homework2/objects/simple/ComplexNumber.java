package ru.spsuace.homework2.objects.simple;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 * Плюс реализуйте 2 любых метод (операций) над комплексными числами (на ваш выбор).
 * Одна опреация должна быть статической, другая - нет.
 */
public class ComplexNumber {
    private final double real;
    private final double imaje;

    public ComplexNumber(double real, double imaje) {
        this.real = real;
        this.imaje = imaje;
    }

    public double getReal() {
        return real;
    }

    public double getImaje() {
        return imaje;
    }

    public static ComplexNumber sum(ComplexNumber cn1, ComplexNumber cn2) {
        return new ComplexNumber(cn1.getReal() + cn2.getReal(), cn1.getImaje() + cn2.getImaje());
    }

    public ComplexNumber multi(ComplexNumber cn1) {
        return new ComplexNumber(cn1.getReal() * getReal() - cn1.getImaje() * getImaje(), cn1.getReal() * getImaje() + cn1.getImaje() * getReal());
    }

    public String toString() {
        if (getImaje() < 0) {
            return getReal() + "-i*" + getImaje() * -1;
        } else {
            return getReal() + "+i*" + getImaje();
        }
    }

    public static void main(String[] args) {
        ComplexNumber x = new ComplexNumber(1, 5);
        ComplexNumber y = new ComplexNumber(-7, -4);
        System.out.println("z1=" + x + ",z2=" + y);

        ComplexNumber a = new ComplexNumber(6, 2);
        System.out.println(a.toString());

        ComplexNumber z;
        z = ComplexNumber.sum(x, y);
        System.out.println("+:" + z);
    }
}