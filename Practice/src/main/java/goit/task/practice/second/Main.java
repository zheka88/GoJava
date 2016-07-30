package goit.task.practice.second;

public class Main {
    public static void main(String[] args) {
        int a = 123456;
        int result = 0;
        while (a > 0) {
            result += a % 10;
            a = a / 10;
        }
        System.out.println(result);
    }
}
