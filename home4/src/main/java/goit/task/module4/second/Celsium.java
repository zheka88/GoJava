package goit.task.module4.second;


public class Celsium {
    private double fahrenheit;
    private final double DIFF = 32;
    private final double FACTOR = 1.8;

    public double getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(double fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public double inCelsium(double fahrenheit) {
        return (fahrenheit - DIFF) / FACTOR;
    }
}
