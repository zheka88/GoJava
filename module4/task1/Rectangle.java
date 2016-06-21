package com.GoJava.module4.task1;


public class Rectangle implements Pifagor {
    private double height;
    private double weight;

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double areaCompute() {
        return height * weight;
    }
}
