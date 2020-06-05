package ru.spsuace.homework2.objects.simple;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 * Плюс реализуйте 2 любых метод (операций) над комплексными числами (на ваш выбор).
 * Одна опреация должна быть статической, другая - нет.
 */
    public class ComplexNumber {
        private final double imagine;
        private final double real;

    public ComplexNumber(double real, double imagine) {
            this.imagine = imagine;
            this.real = real;
        }

        public double getReal() {
            return real;
        }

        public double getImagine() {
            return imagine;
        }
        public double getModule(){
        return Math.sqrt(Math.pow(real,2) + Math.pow(imagine,2));
        }
    public double getArg() {
        if (real > 0) {
            return Math.atan(imagine / real);
        } else {
            if (real < 0 && imagine > 0) {
                return Math.PI + Math.atan(imagine / real);
            } else {
                return -Math.PI + Math.atan(imagine / real);
            }
        }
    }
        public String toString() {
            if (imagine>0) {
                return "Комплексное число:" + real + "+" + Math.abs(imagine) + "*i";
            }
            if (imagine<0){
                return "Комплексное число:" + real + "-" + Math.abs(imagine)+ "*i";
            }
            return "Комплексное число:"+real;
        }

        public boolean equals(Object number, double eps) {
            if (number == null || getClass() != number.getClass()) {
                return false;
            }
            return (Math.abs(real - ((ComplexNumber) number).real) < eps) && (Math.abs(imagine - ((ComplexNumber) number).imagine) < eps);
        }


        public static ComplexNumber sum(ComplexNumber y1, ComplexNumber y2) {
            return new ComplexNumber(y1.getReal() + y2.getReal(), y1.getImagine() + y2.getImagine());
        }

        public ComplexNumber compos(ComplexNumber y,int power) {
            double factor = Math.pow(y.getModule(), power);
            return new ComplexNumber(factor * Math.cos(power * y.getArg()), factor * Math.sin(power * y.getArg()));
        }
    }
