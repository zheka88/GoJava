package goit.task.module08.ierarchy;


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

    @Override
    public String toString() {
        return "Celsium\t" +
                "fahrenheit=" + fahrenheit +
                "\t DIFF=" + DIFF +
                "\t FACTOR=" + FACTOR;
    }
}
