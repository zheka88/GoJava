package goit.task.practice2_1.Fourth;

public class Main {
    public static String toInt(String number) {
        char abc[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
        char[] numberChar = number.toCharArray();
        StringBuilder result = new StringBuilder();
        for (char c : numberChar) {
            for (int i = 0; i < abc.length; i++) {
                if (c == abc[i]) {
                    result.append(i);
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt(toInt("bcd")));
    }
}
