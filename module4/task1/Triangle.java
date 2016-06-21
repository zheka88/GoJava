package com.GoJava.module4.task1;


public class Triangle implements Pifagor {
    private double width;
    private double height;

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double areaCompute() {
        return 0.5 * width * height;
    }
}
