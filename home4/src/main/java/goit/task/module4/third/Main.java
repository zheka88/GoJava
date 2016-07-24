package goit.task.module4.third;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static double findLong(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }
    public static void main(String[] args) throws IOException {
        Point p1 = new Point();
        Point p2 = new Point();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("This programm calculate the distance betwen two points.");
        System.out.println("Please enter the first point's coordinate:" + "\n" + "x");
        p1.setX(Integer.parseInt(input.readLine()));
        System.out.println("y");
        p1.setY(Integer.parseInt(input.readLine()));
        System.out.println("Please enter the second point's coordinate:" + "\n" + "x");
        p2.setX(Integer.parseInt(input.readLine()));
        System.out.println("y");
        p2.setY(Integer.parseInt(input.readLine()));
        System.out.println("The distance betwen your points = " + findLong(p1, p2));

    }
}
