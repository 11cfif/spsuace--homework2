package ru.spsuace.homework2.objects.simple;
import java.util.Objects;
/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 * Плюс реализуйте 2 любых метод (операций) над комплексными числами (на ваш выбор).
 * Одна опреация должна быть статической, другая - нет.
 */
public class ComplexNumber {

    private  double re;
    private  double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public String toString() {
        return "ComplexNumber{" + re + "+" + im + "i}";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        ComplexNumber coNum = (ComplexNumber) obj;
        return (re == coNum.re && im == coNum.im);
    }

    @Override
    public int hashCode() {
        return Objects.hash(re, im);
    }

    public ComplexNumber sum(ComplexNumber n1, ComplexNumber n2) {
        double re = n1.getRe() + n2.getRe();
        double im = n1.getIm() + n2.getIm();
        return new ComplexNumber(re, im);
    }


    public static ComplexNumber diff(ComplexNumber n1, ComplexNumber n2) {
        double re = n1.getRe() - n2.getRe();
        double im = n1.getIm() - n2.getIm();
        return new ComplexNumber(re, im);
    }

    public ComplexNumber makeOpposite() {
        this.re = 0 - re;
        this.im = 0 - im;
        return this;
    }

    public boolean isEqual(ComplexNumber n1, ComplexNumber n2) {
        return (n1.getRe() == n2.getRe() && n1.getIm() == n2.getIm());
    }


}