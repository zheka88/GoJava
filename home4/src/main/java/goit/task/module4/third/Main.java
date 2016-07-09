package goit.task.module4.third;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static double findLong() {
        return Math.sqrt(Math.pow(Point2.getX() - Point1.getX(), 2) + Math.pow(Point2.getY() - Point1.getY(), 2));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("This programm calculate the distance betwen two points.");
        System.out.println("Please enter the first point's coordinate:" + "\n" + "x");
        Point1.setX(Integer.parseInt(input.readLine()));
        System.out.println("y");
        Point1.setY(Integer.parseInt(input.readLine()));
        System.out.println("Please enter the second point's coordinate:" + "\n" + "x");
        Point2.setX(Integer.parseInt(input.readLine()));
        System.out.println("y");
        Point2.setY(Integer.parseInt(input.readLine()));
        System.out.println("The distance betwen your points = " + findLong());

    }
}
