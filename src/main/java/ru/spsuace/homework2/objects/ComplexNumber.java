package ru.spsuace.homework2.objects;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 */
public class ComplexNumber {
    private final double valid;
    private final double complex;

    public ComplexNumber(double valid, double complex) {
        this.valid = valid;
        this.complex = complex;
    }

    public double getValid() {
        return this.valid;
    }

    public double getComplex() {
        return this.complex;
    }

    @Override
    public String toString() {
        double si;
        if (complex > 0) {
            si = '+';
        } else {
            si = '-';
        }
        return "" + valid + si + Math.abs(complex) + 'i';
    }

    public int hashCode() {
        String n = toString();
        return n.hashCode();
    }

    public boolean equlars(ComplexNumber num) {
        return ((Math.abs(this.complex - num.complex) < 1e-4) && (Math.abs(this.valid - num.valid) < 1e-4));
    }
}
