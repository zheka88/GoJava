package goit.task.module5.task1;

public class ArrayMinMax {
    int[] array;
    private int min;
    private int max;

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
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
