package goit.task.module08.first;
import goit.task.module08.ierarchy.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List arr = new ArrayList<>();
        List list = new LinkedList<>();
        Map<Integer, Object> map = new HashMap<>();
        Celsium celsium = new Celsium();
        Circle circle = new Circle();
        Fahrenheit fahrenheit = new Fahrenheit();
        Point point = new Point();
        Rectangle rectangle = new Rectangle();
        Triangle triangle = new Triangle();

        arr.add(celsium);
        arr.add(circle);
        arr.add(fahrenheit);
        arr.add(point);
        arr.add(rectangle);
        arr.add(triangle);

        System.out.println("ArrayList\n");
        for (Object o : arr) {
            System.out.println(o);
        }

        System.out.println("\nList\n");
        list.add(celsium);
        list.add(circle);
        list.add(fahrenheit);
        list.add(point);
        list.add(rectangle);
        list.add(triangle);
        Iterator listi = list.iterator();
        while (listi.hasNext()) {
            System.out.println(listi.next());
    }
        map.put(1, celsium);
        map.put(2, circle);
        map.put(3, fahrenheit);
        map.put(4, point);
        map.put(5, rectangle);
        map.put(6, triangle);

        System.out.print("\nMap\n");
        for (Map.Entry entry: map.entrySet()) {
            Integer key = (Integer) entry.getKey();
            Object value = entry.getValue();
            System.out.print(key);
            System.out.print(" ---> ");
            System.out.println(value);
        }
    }
}
