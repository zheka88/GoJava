package goit.task.module08.ierarchy;


public class Triangle implements Figure {
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
        return 0.5 * width * height;
    }

    @Override
    public String toString() {
        return "Triangle\t" +
                "width=" + width +
                "\t height=" + height;
    }
}
