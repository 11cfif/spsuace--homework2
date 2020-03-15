package ru.spsuace.homework2.objects.simple;

import sun.security.ec.point.ProjectivePoint;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 * Плюс реализуйте любой метод (операцию) над комплексными числами (на ваш выбор)
 */
public class ComplexNumber {
    private int valid;
    private int imaginary;
    private String i;

    public ComplexNumber(int valid, int imaginary, String i) {
        this.valid = valid;
        this.imaginary = imaginary;
        this.i = "i";
    }
    public void setValid(int valid){
        this.valid = valid;
    }
    public void setImaginary(int imaginary) {
        this.imaginary = imaginary;
    }
    public final void setI(String i) {
        this.i = "i";
    }


}
