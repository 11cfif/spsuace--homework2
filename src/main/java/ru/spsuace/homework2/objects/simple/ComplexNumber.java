package ru.spsuace.homework2.objects.simple;

import java.sql.SQLOutput;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 * Плюс реализуйте 2 любых метод (операций) над комплексными числами (на ваш выбор).
 * Одна опреация должна быть статической, другая - нет.
 */

public class ComplexNumber {
    private final double imZ;
    private final double reZ;

    public ComplexNumber(double reZ, double imZ) {
        this.imZ = imZ;
        this.reZ = reZ;
    }

    public double getReZ() {
        return reZ;
    }

    public double getImZ() {
        return imZ;
    }

    private double getModule() {
        return Math.sqrt(Math.pow(this.reZ, 2) + Math.pow(this.imZ, 2));
    }

    public static ComplexNumber sum(ComplexNumber comp_num1, ComplexNumber comp_num2) {
        return new ComplexNumber(comp_num1.getReZ() + comp_num2.getReZ(), comp_num1.getImZ() + comp_num2.getImZ());
    }

    private double GetArg() {
        if (this.reZ > 0) {
            return Math.atan(imZ / reZ);
        } else {
            if (reZ < 0 && imZ > 0) {
                return Math.PI + Math.atan(imZ / reZ);
            } else {
                return -Math.PI + Math.atan(imZ / reZ);
            }
        }
    }

    public static ComplexNumber pow(ComplexNumber comp_num, int power) {
        double factor = Math.pow(comp_num.getModule(), power);
        return new ComplexNumber(factor * Math.cos(power * comp_num.GetArg()), factor * Math.sin(power * comp_num.GetArg()));
    }

    private String sign() {
        if (imZ > 0) return " + ";
        else return " - ";
    }

    public String toString() {
        String string;
        if (imZ == 1 || imZ == -1) {
            if (reZ == 0) {
                string = sign() + "i";
            } else {
                string = reZ + sign() + "i";
            }
        } else {
            string = reZ + sign() + Math.abs(imZ) + "i";
        }
        return string;
    }

    public boolean equals(ComplexNumber number) {
        return this.getClass() == number.getClass();
    }

    public static void main(String[] args) {
        ComplexNumber x = new ComplexNumber(2, 3);
        ComplexNumber y = new ComplexNumber(-1, 2);
        System.out.println("z1 = " + x + ",     z2 = " + y);

        ComplexNumber z;

        z = ComplexNumber.sum(x, y);
        System.out.println("+ : " + z);

        z = ComplexNumber.pow(y, 2);
        System.out.println("Pow 2 of z2 : " + z);
    }
}