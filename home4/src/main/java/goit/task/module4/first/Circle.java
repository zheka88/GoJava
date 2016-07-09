package goit.task.module4.first;


public class Circle implements Figure {
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
