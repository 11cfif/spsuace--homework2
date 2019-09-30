package ru.spsuace.homework2.objects;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 * Плюс реализуйте любой метод (операцию) над комплексными числами (на ваш выбор)
 */
public class ComplexNumber {

    private final int real;
    private final int complex;

    public ComplexNumber(int real, int complex) {
        this.real = real;
        this.complex = complex;
    }

    public int getReal() {
        return real;
    }

    public int getComplex() {
        return complex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ComplexNumber that = (ComplexNumber) o;
        return real == that.real && complex == that.complex;
    }

    @Override
    public int hashCode() {
        return Math.abs(this.real) + Math.abs(this.complex);
    }

    @Override
    public String toString() {
        if (this.complex < 0) {
            return this.real + " - " + Math.abs(this.complex) + "i";
        } else {
            return this.real + " + " + this.complex + "i";
        }
    }


    public static void main(String[] args) {
        System.out.println(new ComplexNumber(4, -4));
    }
}
