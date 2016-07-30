package goit.task.practice.fifth;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] snake = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        List result = new ArrayList();
        for (int i = 0; i < snake.length; i++) {
            result.add(snake[i][0]);
        }
        for (int i = snake.length - 1; i > -1; i--) {
            result.add(snake[i][1]);
        }
        for (int i = 0; i < snake.length; i++) {
            result.add(snake[i][2]);
        }
        System.out.println(result.toString());
    }
}
