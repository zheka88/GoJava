package goit.task.module08.ierarchy;


public class Rectangle implements Figure {
    private double width;
    private double height;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double areaCompute() {
        return height * width;
    }

    @Override
    public String toString() {
        return "Rectangle\t" +
                "width=" + width +
                "\t height=" + height;
    }
}
