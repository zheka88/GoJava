package goit.task.practice.first;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        String numeros = new String();
        for (int i = 0; i < array.length; i++) {
            numeros += array[i];
        }
        int value = Integer.parseInt(numeros);
        System.out.println(value);
    }
}
