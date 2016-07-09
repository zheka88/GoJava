package goit.task.module4.second;


public class Fahrenheit {
    private double celsium;
    private final double DIFF = 32;
    private final double FACTOR = 1.8;

    public double getCelsium() {
        return celsium;
    }

    public void setCelsium(double celsium) {
        this.celsium = celsium;
    }

    public double inFahrenheit(double celsium) {
        return FACTOR * celsium + DIFF;
    }
}
