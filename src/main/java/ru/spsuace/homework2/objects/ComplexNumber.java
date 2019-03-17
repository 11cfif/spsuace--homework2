package ru.spsuace.homework2.objects;

import java.util.Objects;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 */

public class ComplexNumber {
    private final double Re; //real part
    private final double Im; //imaginary part

    //конструктор
    public ComplexNumber(double Re, double Im) {
        this.Re = Re;
        this.Im = Im;
    }

    //геттер Im
    public double getIm() {
        return Im;
    }

    //геттер Re
    public double getRe() {
        return Re;
    }

    //в string
    public String toString() {

        return Re + " + i( " + Im + ")";
    }

    //присваивание и сравнение
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        ComplexNumber CoNum = (ComplexNumber) obj;
        return (Re == CoNum.Re && Im == CoNum.Im);

    }

    //HashCode для HashMap
    @Override
    public int hashCode() {
        return Objects.hash(Re, Im);
    }
}
