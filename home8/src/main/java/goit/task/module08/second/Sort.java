package goit.task.module08.second;
import goit.task.module08.ierarchy.*;
import java.util.*;

public class Sort {
    public static void main(String[] args) {
        ObjectComparator oc = new ObjectComparator();
        Set arrlist = new TreeSet(oc);
        arrlist.add(new Rectangle());
        arrlist.add(new Circle());
        arrlist.add(new Triangle());
        arrlist.add(new Point());
        arrlist.add(new Fahrenheit());
        arrlist.add(new Celsium());

        for (Object o : arrlist)
            System.out.println(o);
    }
}

