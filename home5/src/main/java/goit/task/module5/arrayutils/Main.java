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
        int[] inar = new int[in.nextInt()];
        System.out.println("Now choose a fill type:\n1 - by your hands\t2 - random(from -length to length with 0)");
        try {
            switch (in.nextInt()) {
                case 1:
                    for (int i = 0; i < inar.length; i++) {
                        if (i == 0) {
                            System.out.println("O.K! Type the value number " + (i + 1) + ":");
                            inar[i] = in.nextInt();
                        } else if (i == inar.length - 1) {
                            System.out.println("and the last one:");
                            inar[i] = in.nextInt();
                            break;
                        } else {
                            System.out.println("number " + (i + 1) + ":");
                            inar[i] = in.nextInt();
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < inar.length; i++) {
                        inar[i] = rand.nextInt(inar.length * 2 + 1) - inar.length;
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Wrong input!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Your array...\n" + Arrays.toString(inar));
        ArrayUtils.minMax(inar);
        System.out.println(ArrayUtils.sort(inar));
    }
}
