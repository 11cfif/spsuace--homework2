package ru.spsuace.homework2.objects;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 */
public class ComplexNumber {

    private final double realPart;
    private final double imaginaryPart;

    public ComplexNumber(double realPartSet, double imaginaryPartSet) {
        this.realPart = realPartSet;
        this.imaginaryPart = imaginaryPartSet;
    }

    public double getRealPart() {
        return realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    @Override
    public String toString() {

        String signAndImagine = imaginaryPart > 0 ? " + i*" : " - i*";
        String real = String.valueOf(realPart);
        if (realPart == 0) {
            real = "";
            signAndImagine = "i";
        }
        String imagin = String.valueOf(Math.abs(imaginaryPart));
        if (imaginaryPart == 0) {
            imagin = "";
            signAndImagine = "";
        }
        if (realPart == 0 && imaginaryPart == 0) {
            return "0";
        }
        return real + signAndImagine + imagin;
    }

    public double module() {
        return Math.sqrt(realPart * realPart + imaginaryPart * imaginaryPart);
    }

    public ComplexNumber multiplication(ComplexNumber current) {
        return new ComplexNumber((realPart * current.realPart - imaginaryPart * current.imaginaryPart),
                (realPart * current.imaginaryPart + imaginaryPart * current.realPart));
    }

    private static int lengthOfNumber(double number) {
        return String.valueOf((int) number).length();
    }

    @Override
    public int hashCode() {
        return (int) (555 * Math.pow(10, lengthOfNumber(realPart) + lengthOfNumber(imaginaryPart)) +
                Math.pow(10, lengthOfNumber(realPart)) * realPart + imaginaryPart);
    }

    @Override
    public boolean equals(Object obj) {
        return (realPart - ((ComplexNumber) obj).realPart < 1e-4) &&
                (imaginaryPart - ((ComplexNumber) obj).imaginaryPart < 1e-4);
    }
}
