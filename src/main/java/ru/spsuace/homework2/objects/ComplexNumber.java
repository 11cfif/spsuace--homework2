package ru.spsuace.homework2.objects;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 */
public class ComplexNumber {
    private final double rePart;
    private final double imPart;


    public ComplexNumber(double rePart, double imPart) {
        this.rePart = rePart;
        this.imPart = imPart;
    }

    public double getRePart() {
        return rePart;
    }

    public double getImPart() {
        return imPart;
    }
    public double module() {
        return Math.sqrt(Math.pow(this.rePart,2)+Math.pow(this.imPart,2));
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
        if (Double.doubleToLongBits(this.rePart) != Double.doubleToLongBits(other.rePart)) {
            return false;
        }
        if (Double.doubleToLongBits(this.imPart) != Double.doubleToLongBits(other.imPart)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        double result = 1;
        result = prime * result + rePart;
        result = prime * result + imPart;
        return (int) result;
    }

    @Override
    public String toString() {
        char sign;
        if (imPart > 0) {
            sign = '+';
        } else {
            sign = '-';
        }
        return "Complex: " + rePart + sign + Math.abs(imPart) + "i";
    }

}
