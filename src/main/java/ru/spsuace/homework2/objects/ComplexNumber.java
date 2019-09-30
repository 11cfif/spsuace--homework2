package ru.spsuace.homework2.objects;

import java.util.Objects;
/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 */
public class ComplexNumber {

    private final  double realPart;
    private final double imPart;

    public ComplexNumber(Double realPart, Double imPart) {
        this.realPart = realPart;
        this.imPart = imPart;
    }

    public double getRealPart() {
        return realPart;
    }


    public double getImPart() {
        return imPart;
    }

    @Override
    public String toString() {
        char sign;
        if (imPart > 0) {
            sign = '+';
        } else {
            sign = '-';
        }
        return " " + realPart + sign + Math.abs(imPart) + 'i';
    }

    @Override
    public int hashCode() {
        return  Objects.hash(realPart, imPart);
    }

    public boolean equals(Object o) {
        if (o instanceof ComplexNumber) {
            ComplexNumber number = (ComplexNumber)o;
            if ((number.getRealPart() == realPart) && (number.getImPart() == imPart)) {
                return  true;
            }
        }
        return  false;
    }
}
