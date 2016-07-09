package goit.task.module4.second;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Fahrenheit fahrenheit = new Fahrenheit();
        Celsium celsium = new Celsium();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("This programm calculate celsium to fahrenheit and vice versa");
        System.out.println("Choose the value you want to input:");
        System.out.println("Celsium:  1" + "\n" + "Fahrenheit:  2");

        if (Integer.parseInt(input.readLine()) == 1) {
            System.out.println("Enter Celsium degree:");
            System.out.println("It's " + fahrenheit.inFahrenheit(Double.parseDouble(input.readLine())) + " Fahrenheit");
        } else if (Integer.parseInt(input.readLine()) == 1) {
            System.out.println("Enter Fahrenheit degree:");
            System.out.println("It's " + celsium.inCelsium(Double.parseDouble(input.readLine())) + " Celsium");
        } else {
            System.out.println("Wrong input!" + "\n" + "Try again...");
        }
    }
}
