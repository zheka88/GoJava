package goit.task.practice2_1.Sixth;

public class Main {
    public static int set(int num, int i) {

        String binary = Integer.toBinaryString(num);
        char[] bits = binary.toCharArray();

        if ((i >= 1) && (i <= bits.length)) {
            bits[bits.length - i] = '0';
        }

        if (num < 0) {
            bits[0] = '0';
            binary = String.valueOf(bits);
            return Integer.parseInt(binary, 2)*(-1)-2;
        }

        binary = String.valueOf(bits);
        return Integer.parseInt(binary, 2);
    }

    public static void main(String[] args) {
        set(6, 2);
    }
}
