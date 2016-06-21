package com.GoJava.module4.task2;


public class FahrenheitCelsium {
    public double celsiy;
    public double fahreheit;
    private static final double diff = 32.0;
    private static final double factor = 1.8;

    public double fromCelsium(double celsiy) {
        return factor * celsiy + diff;
    }

    public double fromFahrenheit(double fahreheit) {
        return (fahreheit - diff) / factor;
    }
}
