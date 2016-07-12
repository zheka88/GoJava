package goit.task.module6;

import java.util.List;

public class Shop {
    List<Instrument> instruments;

    public List<Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<Instrument> instruments) {
        this.instruments = instruments;
    }

    @Override
    public String toString() {
        return "Shop{instruments = " + instruments + "}";
    }
}
