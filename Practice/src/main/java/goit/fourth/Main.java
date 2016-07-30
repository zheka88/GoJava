package goit.task.practice.fourth;

public class Main {
    public static void main(String[] args) {
        int[] array = {59, 3, 48, 17, 86, 53, 70, 900, 14, 5, 49};
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println(max);
    }
}
