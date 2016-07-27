package goit.task.module08.ierarchy;


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

    @Override
    public String toString() {
        return "Fahrenheit\t" +
                "celsium=" + celsium +
                "\t DIFF=" + DIFF +
                "\t FACTOR=" + FACTOR;
    }
}
