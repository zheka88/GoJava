package goit.task.practice2_1.Second;

public class Main {
    public static int average(int a, int b) {
        a = (a < 0) ? -a : a;
        b = (b < 0) ? -b : b;
        return (a + b) / 2;
    }

    public static void main(String[] args) {
        System.out.println(average(4, 7));
    }
}
