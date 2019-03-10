package ru.spsuace.homework2.objects;

import java.util.Objects;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 */
public class ComplexNumber {
    private final double rePart;
    private final double imPart;

    ComplexNumber(double rePart, double imPart) {
        this.rePart = rePart;
        this.imPart = imPart;
    }

    public double getRePart() {
        return rePart;
    }

    public double getImPart() {
        return imPart;
    }

    @Override
    public String toString() {
        return rePart + " + " + imPart + "*i";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ComplexNumber that = (ComplexNumber) obj;
        return (Objects.equals(rePart, that.rePart) && Objects.equals(imPart, that.imPart));
    }

    @Override
    public int hashCode() {
        final int prime = 7;
        int result = 1;
        result = (int) (prime * result + rePart);
        result = (int) (prime * result + imPart);
        return result;
    }
}

