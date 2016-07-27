package goit.task.module08.ierarchy;

public class Point {
    private int x;
    private int y;
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point\t" +
                "x=" + x +
                "\t y=" + y;
    }
}
