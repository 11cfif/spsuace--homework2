package ru.spsuace.homework2.objects;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 * Плюс реализуйте любой метод (операцию) над комплексными числами (на ваш выбор)
 */
public class ComplexNumber {
    private final double supposed;
    private final double real;

    public ComplexNumber(double supposed, double real) {
        this.supposed = supposed;
        this.real = real;
    }

    public double getSupposed() {
        return supposed;
    }

    public double getReal() {
        return real;
    }

    @Override
    public java.lang.String toString() {
        return "ComplexNumber{" +
                "Im=" + supposed +
                ", Re=" + real +
                '}';
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
        return Double.compare(that.supposed, supposed) == 0 &&
                Double.compare(that.real, real) == 0;
    }
}
