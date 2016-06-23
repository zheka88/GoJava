package ua.GoJAVA.home.task1;

/**
 *
 */
public class ArrayMinMax {
    public static void main(String[] args) {
        int minValue = 0;
        int maxValue = 0;

        int[] intArr = {2, 0, 8, -9, 4, -15, 19, -7, 22, 12};

        minValue = intArr[0];
        for (int i = 1; i < intArr.length; i++) {
            if(intArr[i] < minValue)
                minValue = intArr[i];
                System.out.print(minValue + " ");
        }

        System.out.println(minValue + "\n");

        maxValue = intArr[0];
        for(int i = 1; i < intArr.length; i++) {
            if(intArr[i] > maxValue)
                maxValue = intArr[i];
                System.out.print(maxValue + " ");
        }

        System.out.println(maxValue);

    }
}
