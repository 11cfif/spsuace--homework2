package ru.spsuace.homework2.objects;


/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 */
public class ComplexNumber {
    private final double real;
    private final double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getImaginary() {
        return imaginary;
    }

    public double getReal() {
        return real;
    }

    public String toString() {
        String complex = "";
        return complex + real + " + " + imaginary + 'i';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        ComplexNumber complexNumber = (ComplexNumber) obj;
        return (real == complexNumber.real && imaginary == ((ComplexNumber) obj).imaginary);

    }

    //it's a magic
    @Override
    public int hashCode() {
        final int prime = 31;
        double result = 1;
        result = prime * result + real;
        result = prime * result + imaginary;
        return (int) result;
    }

}
