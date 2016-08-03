package goit.task.module5.arrayutils;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalArgumentException {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("This program search the min/max array value.");
        System.out.println("Let's create an array!");
        System.out.println("Please add the array length:");
        int[] array = new int[in.nextInt()];
        System.out.println("Now choose a fill type:\n1 - by your hands\t2 - random(from -length to length with 0)");

        try {
            switch (in.nextInt()) {
                case 1:
                    System.out.print("O.K! Type the value ");
                    for (int i = 0; i < array.length; i++) {
                        if (i == array.length - 1) {
                            System.out.println("and the last one:");
                            array[i] = in.nextInt();
                        } else {
                            System.out.println("number " + (i + 1) + ":");
                            array[i] = in.nextInt();
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < array.length; i++) {
                        array[i] = rand.nextInt(array.length * 2 + 1) - array.length;
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Wrong input!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Your array...\n" + Arrays.toString(array));
        System.out.println("Min value is: " + ArrayUtils.minMax(array).getMin());
        System.out.println("Max value is: " + ArrayUtils.minMax(array).getMax());
        System.out.println(Arrays.toString(ArrayUtils.sort(array)));
    }
}
