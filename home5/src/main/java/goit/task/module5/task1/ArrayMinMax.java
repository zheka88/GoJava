package goit.task.module5.task1;

public class ArrayMinMax {
    int[] array;
    int min;
    int max;

    public ArrayMinMax(int[] array) {
        this.array = array;
        min = array[0];
        max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            } else if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("Min value = " + min);
        System.out.println("Max value = " + max);
    }
}
