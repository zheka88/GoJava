package goit.task.practice.sixth;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] spiral = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        int[] result = new int[spiral.length * spiral[0].length];
        int x = spiral[0].length - 1;
        int y = spiral.length - 1;
        int startX = 0;
        int startY = 0;
        int count = 0;
        int index = 0;
        while (index < spiral.length * spiral[0].length) {
            if (count == 0) {
                for (int i = startY; i <= x; i++) {
                    result[index] = spiral[startX][i];
                    index++;
                }
                startX++;
            }
            if (count == 1) {
                for (int i = startX; i <= y; i++) {
                    result[index] = spiral[i][x];
                    index++;
                }
                x--;
            }
            if (count == 2) {
                for (int i = x; i >= startY; i--) {
                    result[index] = spiral[y][i];
                    index++;
                }
                y--;
            }
            if (count == 3) {
                for (int i = y; i >= startX; i--) {
                    result[index] = spiral[i][startY];
                    index++;
                }
                startY++;
            }
            count++;
            count %= 4;
        }
        System.out.print(Arrays.toString(result));
    }
}
