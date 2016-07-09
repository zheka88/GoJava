package goit.task.module4.first;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Circle circle = new Circle();
        Triangle triangle = new Triangle();
        Rectangle rectangle = new Rectangle();

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("This programm make a square compute.");
        System.out.println("Choose a figure type:");
        System.out.println("1 = Circle" + "\n" + "2 = Triangle" + "\n" + "3 = Rectangle");

        int i = Integer.parseInt(input.readLine());

        switch(i) {
            case (1):
                System.out.println("Enter a radius:");
                circle.setRadius(Double.parseDouble(input.readLine()));
                System.out.println("Square of your circle = " + circle.areaCompute());
                break;
            case (2):
                System.out.println("Enter a width:");
                triangle.setWidth(Double.parseDouble(input.readLine()));
                System.out.println("Enter a height:");
                triangle.setHeight(Double.parseDouble(input.readLine()));
                System.out.println("Square of your triangle = " + triangle.areaCompute());
                break;
            case (3):
                System.out.println("Enter a width:");
                rectangle.setWidth(Double.parseDouble(input.readLine()));
                System.out.println("Enter a height:");
                rectangle.setHeight(Double.parseDouble(input.readLine()));
                System.out.println("Square of your rectangle = " + rectangle.areaCompute());
                break;
            default:
                System.out.println("You made wrong input." + "\n" + "Please try again...");
                break;

        }
    }
}
