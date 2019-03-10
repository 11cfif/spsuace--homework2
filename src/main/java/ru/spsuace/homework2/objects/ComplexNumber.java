package ru.spsuace.homework2.objects;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 */
public class ComplexNumber {

    private final double realPart;
    private final double imaginaryPart;

    ComplexNumber(double realPart, double imaginaryPart) {

        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public double getRealPart() {
        return realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public String toString() {

        String sign = imaginaryPart < 0 ? "-" : "+";

        return realPart + " " + sign + " " + Math.abs(imaginaryPart) + "i";
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        ComplexNumber complex = (ComplexNumber) obj;
        return (realPart == complex.realPart && imaginaryPart == complex.imaginaryPart);
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        double result = 1;
        result = prime * result + realPart;
        result = prime * result + imaginaryPart;
        return (int) result;
    }

}
