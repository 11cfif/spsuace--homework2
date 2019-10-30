package ru.spsuace.homework2.objects;

import java.util.Objects;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 * Плюс реализуйте любой метод (операцию) над комплексными числами (на ваш выбор)
 */
public class ComplexNumber {
    private final double realPart;
    private final double imagPart;

    public ComplexNumber(double realPart, double imagPart) {
        this.realPart = realPart;
        this.imagPart = imagPart;
    }

    public double getRealPart() {
        return realPart;
    }

    public double getImagPart() {
        return imagPart;
    }

    @Override
    public String toString() {
        char sign;
        if (imagPart > 0) {
            sign = '+';
        } else {
            sign = '-';
        }
        return " " + realPart + sign + Math.abs(imagPart) + 'i';
    }

    @Override
    public int hashCode() {
        return Objects.hash(realPart, imagPart);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ComplexNumber) {
            ComplexNumber number = (ComplexNumber) o;
            if ((number.getRealPart() == realPart) && (number.getImagPart() == imagPart)) {
                return true;
            }
        }
        return false;
    }

    public double mod() {
        return (double) Math.sqrt(realPart * realPart + imagPart * imagPart);
    }
}
