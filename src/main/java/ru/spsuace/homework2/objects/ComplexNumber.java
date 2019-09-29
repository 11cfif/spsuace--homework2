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

        String signAndImagine = " + i*";
        if (imaginaryPart < 0) {
            signAndImagine = " - i*";
        }
        String real = String.valueOf((int)realPart);
        if (realPart == 0) {
            real = "";
            signAndImagine = "i";
        }
        String imagin = String.valueOf((int)Math.abs(imaginaryPart));
        if (imaginaryPart == 0) {
            imagin = "";
            signAndImagine = "";
        }
        if (realPart == 0 && imaginaryPart == 0) {
            return "0";
        }
        return real + signAndImagine + imagin;
    }

    public final void output() {
        System.out.println(toString());
    }

    public double module() {
        return Math.sqrt(realPart * realPart + imaginaryPart * imaginaryPart);
    }

    public String multiplication(ComplexNumber number1, ComplexNumber number2) {
        ComplexNumber current = new ComplexNumber((number1.realPart * number2.realPart - number1.imaginaryPart * number2.imaginaryPart), number1.realPart * number2.imaginaryPart + number1.imaginaryPart * number2.realPart);
        return current.toString();
    }

    public int lengthOfNuber(double number) {
        return String.valueOf((int)number).length();
    }

    @Override
    public int hashCode() {
        return (int) (555 * Math.pow(10, lengthOfNuber(realPart) + lengthOfNuber(imaginaryPart)) + Math.pow(10, lengthOfNuber(realPart)) * realPart + imaginaryPart);
    }
}
