package goit.task.module6;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Shop shop = new Shop();
        ArrayList<Instrument> instruments = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            instruments.add(new Piano());
        }

        for (int i = 0; i < 16; i++) {
            instruments.add(new Guitar());
        }

        for (int i = 0; i < 7; i++) {
            instruments.add(new Trumpet());
        }
        shop.setInstruments(instruments);
        System.out.println(shop);
        Map<String, Integer> order = new HashMap<>();
        order.put("guitar", 7);
        order.put("trumpet", 2);

        try {
            List<Instrument> instrumentsToBeRemoved = prepareListInstrumentsToRemove(shop, order);
            removeInstrumentFromTheShop(shop, order);
            System.out.println("Order: " + instrumentsToBeRemoved);
        } catch (IllegalArgumentException e) {
            System.out.println("The shop has not such an instrument " + e.getMessage());
        }
        System.out.println(shop);
    }

    private static List<Instrument> prepareListInstrumentsToRemove(Shop shop, Map<String, Integer> order) {
        List<Instrument> result = new ArrayList<>();

        for (Map.Entry<String, Integer> orderEntry : order.entrySet()) {
            String instrumentType = orderEntry.getKey();
            Integer numberOfInstrumentToBeRemoved = orderEntry.getValue();
            int numberOfInstrumentsRemoved = 0;
            for (Instrument instrument : shop.getInstruments()) {
                if (instrument.getType().equals(instrumentType) && numberOfInstrumentsRemoved < numberOfInstrumentToBeRemoved) {
                    result.add(instrument);
                    numberOfInstrumentsRemoved++;
                }
            }
            if (numberOfInstrumentsRemoved < numberOfInstrumentToBeRemoved) {
                throw new IllegalStateException("Shop does not have enough " + instrumentType + "s");
            }
        }
        return result;
    }

    private static void removeInstrumentFromTheShop(Shop shop, Map<String, Integer> order) {
        for (Map.Entry<String, Integer> orderEntry : order.entrySet()) {
            String instrumentType = orderEntry.getKey();
            Integer numberOfInstrumentsToBeRemoved = orderEntry.getValue();
            int numberOfInstrumentsRemoved = 0;
            Iterator<Instrument> iterator = shop.getInstruments().iterator();
            while (iterator.hasNext()) {
                Instrument instrument = iterator.next();
                if (instrument.getType().equals(instrumentType) && numberOfInstrumentsRemoved < numberOfInstrumentsToBeRemoved) {
                    iterator.remove();
                    numberOfInstrumentsRemoved++;
                }
            }
        }
    }
}
