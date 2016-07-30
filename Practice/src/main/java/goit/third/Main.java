package goit.task.practice.third;

public class Main {
    public static void main(String[] args) {
        int[] array = {10, 4, 6, 8, 12, 14, 20, 40, 1000, 70000};
        boolean noOdd = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                System.out.println(array[i]);
                noOdd = false;
                break;
            }
        }
        if (noOdd) {
            System.out.println(-1);
        }
    }
}