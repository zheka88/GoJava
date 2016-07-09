package goit.task.module5.task1;

public class ArrayMinMax {
    public static void main(String[] args) {
        int minValue;
        int maxValue;

        int[] intArr = new int[1000000];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = (int) (Math.random() * 2000000) - 1000000;
        }

        minValue = intArr[0];
        for (int i : intArr) {
            if (i < minValue)
                minValue = i;
        }
        System.out.println(minValue + "\n");

        maxValue = intArr[0];
        for (int i : intArr) {
            if (i > maxValue)
                maxValue = i;
        }
        System.out.println(maxValue);
    }
}
