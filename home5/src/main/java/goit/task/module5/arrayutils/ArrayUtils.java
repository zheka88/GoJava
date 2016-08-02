package goit.task.module5.arrayutils;

import goit.task.module5.task1.ArrayMinMax;
import goit.task.module5.task2.ArraySort;

public class ArrayUtils {
    public static Object minMax(int[] array) {
        return new ArrayMinMax(array);
    }

    public static String sort(int[] array) {
        return ArraySort.arraySort(array);
    }
}
