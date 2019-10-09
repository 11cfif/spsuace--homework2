package ru.spsuace.homework2.objects;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 * Плюс реализуйте любой метод (операцию) над комплексными числами (на ваш выбор)
 */
public class ComplexNumber {
    private final double real;
    private final double imagine;

    public ComplexNumber(double real, double imagine) {
        this.real = real;
        this.imagine = imagine;
    }

    public double getReal() {
        return real;
    }
    public double getImagine() {
        return imagine;
    }
    public double abs() {
        return Math.sqrt(real * real + imagine * imagine);
    }
    @Override
    public String toString() {
        char sign;
        if (imagine > 0) {
            sign = '+';
        } else {
            sign = '-';
        }
        return "" + real + sign + Math.abs(imagine) + "i";
    }
    @Override
    public int hashCode(){
        final int prime=11;
        double result=1;
        result=prime*result+real;
        result=prime*result+imagine;
        return (int) result;
    }
    @Override
    public boolean equals(Object n){
        if (n==null){
            return false;
        } else{
            ComplexNumber numb=(ComplexNumber)n;
            return (Math.abs(this.real-numb.real)==10e-5 && Math.abs(this.imagine- numb.imagine)==10e-5);
        }
    }
}
