package ru.spsuace.homework2.objects.simple;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 * Плюс реализуйте 2 любых метод (операций) над комплексными числами (на ваш выбор).
 * Одна опреация должна быть статической, другая - нет.
 */
public class ComplexNumber {
    private final double imaginePart;
    private final double realPart;

    public ComplexNumber(double realPart, double imaginePart) {
        this.imaginePart = imaginePart;
        this.realPart = realPart;
    }

    public double getRealPart() {
        return realPart;
    }

    public double getImaginePart() {
        return imaginePart;
    }

    public String toString() {
        if (imaginePart > 0) {
            return "Комплексное число:" + realPart + " + " + imaginePart + " * i";
        }
        if (imaginePart < 0){
            return "Комплексное число:" + realPart + " - " + Math.abs(imaginePart)+ "* i";
        }
        return "Комплексное число:" + realPart;
    }

    public boolean equals(Object number) {
        if (number == null || getClass() != number.getClass()) {
            return false;
        }

        double threshold = 0.0001;
        return Math.abs((this.realPart - ((ComplexNumber) number).realPart)) < threshold && Math.abs((this.imaginePart - ((ComplexNumber) number).imaginePart)) < threshold;
    }

    public static ComplexNumber sum(ComplexNumber number1, ComplexNumber number2) {
        return new ComplexNumber(number1.realPart + number2.realPart, number1.imaginePart + number2.imaginePart);
    }

    public ComplexNumber compose(ComplexNumber number) {
        return new ComplexNumber(this.realPart * number.getRealPart() - this.imaginePart * number.getImaginePart(), this.realPart * number.getImaginePart() + this.imaginePart * number.getRealPart());
    }
}