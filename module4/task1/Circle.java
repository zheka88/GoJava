package com.GoJava.module4.task1;


public class Circle implements Pifagor {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double areaCompute() {
        return Math.PI * radius * radius;
    }
}
