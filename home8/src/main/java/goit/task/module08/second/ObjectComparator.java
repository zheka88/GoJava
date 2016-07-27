package goit.task.module08.second;

import java.util.Comparator;

public class ObjectComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        return o1.getClass().getSimpleName().compareTo(o2.getClass().getSimpleName());
    }
}
