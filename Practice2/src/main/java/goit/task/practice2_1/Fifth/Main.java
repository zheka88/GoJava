package goit.task.practice2_1.Fifth;

public class Main {
    public static int bitCounter(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(bitCounter(13));
    }
}
