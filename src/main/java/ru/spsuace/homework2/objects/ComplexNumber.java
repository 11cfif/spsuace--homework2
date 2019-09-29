package ru.spsuace.homework2.objects;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 */
public class ComplexNumber {
    private final double realPart;
    private final double imaginaryPart;

    public ComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public double getRealPart() {
        return realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public double abs() { //модуль комплексного числа
        return Math.sqrt(realPart * realPart + imaginaryPart * imaginaryPart);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ComplexNumber other = (ComplexNumber) obj;
        if (Double.doubleToLongBits(this.realPart) != Double.doubleToLongBits(other.realPart)) {
            return false;
        }
        if (Double.doubleToLongBits(this.imaginaryPart) != Double.doubleToLongBits(other.imaginaryPart)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        double result = 1;
        result = prime * result + realPart;
        result = prime * result + imaginaryPart;
        return (int) result;
    }

    @Override
    public String toString() {
        return "Complex: real part=" + realPart + "?, imaginary part=*" + imaginaryPart;
    }
}