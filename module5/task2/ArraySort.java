package ua.GoJAVA.home.task2;

/**
 */
public class ArraySort {
    public static void main(String[] args) {
        int[] array = {15, 8, 23, 6, -2, 30, 25, -9, -5, 11};

        for(int i = 0; i < array.length; i++) {
            int min = array[i];
            int min_i = i;
            for(int j = i+1; j < array.length; j++) {
                if(array[j] < min){
                    min = array[j];
                    min_i = j;
                }
            }
            if(i !=min_i) {
                int temp = array[i];
                array[i] = array[min_i];
                array[min_i] = temp;
            }
        }
        for(int element : array)
            System.out.print(element + " ");
    }

}
