package ru.spsuace.homework2.objects;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 */
public class ComplexNumber {

    private final double realPart;
    private final double imgPart;

    public ComplexNumber(double realPart, double imgPart) {
        this.realPart = realPart;
        this.imgPart = imgPart;
    }

    public double getImgPart() {
        return imgPart;
    }

    public double getRealPart() {
        return realPart;
    }


    @Override
    public String toString() {

        if (realPart != 0) {
            if (imgPart > 0) {
                return realPart + "+" + imgPart + "i";
            } else if (imgPart == 0) {
                return String.valueOf(realPart);
            } else if (imgPart < 0) {
                return realPart + "-" + Math.abs(imgPart) + "i";
            }
        } else if (realPart == 0) {
            if (imgPart > 0) {
                return imgPart + "i";
            } else if (imgPart == 0) {
                return "0";
            } else if (imgPart < 0) {
                return "-" + Math.abs(imgPart) + "i";
            }
        }
        return "Error";
    }

    public double modulus() {
        return Math.abs(Math.pow(realPart, 2) + Math.pow(imgPart, 2));
    }

    public double argument() {
        if (modulus() == 0) {
            return 0;
        }
        return Math.atan2(imgPart, realPart);
    }

    public int hashCode() {
        return (int) (1000 + modulus() + argument());
    }

    public boolean equals(ComplexNumber Number) {
        return ((Math.abs(this.realPart - Number.realPart) < 1e-4) && (Math.abs(this.imgPart - Number.imgPart) < 1e-4));
    }

}


