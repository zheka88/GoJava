package goit.task.module5.task2;

import java.util.Arrays;

public class ArraySort {
    public static String arraySort(int[] array) {
        int[] arraySort = array.clone();
        for (int i = 0; i < arraySort.length; i++) {
            int min = arraySort[i];
            int min_i = i;
            for (int j = i + 1; j < arraySort.length; j++) {
                if (arraySort[j] < min) {
                    min = arraySort[j];
                    min_i = j;
                }
            }
            if (i != min_i) {
                int temp = arraySort[i];
                arraySort[i] = arraySort[min_i];
                arraySort[min_i] = temp;
            }
        }
        return Arrays.toString(arraySort);
    }
}
