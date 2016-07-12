package goit.task.module6;

abstract class Instrument {
    public abstract String getType();

    @Override
    public String toString() {
        return "Instrument{" + getType() + "}";
    }
}
