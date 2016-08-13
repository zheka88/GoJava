package goit.task.practice2_1.First;

public class Main {
    public static String add(String a, String b) {

        String numbers = "0123456789abcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        a = new StringBuilder(a).reverse().toString().toLowerCase();
        b = new StringBuilder(b).reverse().toString().toLowerCase();


        int lengthOfMaxString;
        String stringOfMaxLength;
        if (a.length() >= b.length()){
            lengthOfMaxString = a.length();
            stringOfMaxLength = a;
        }else {
            lengthOfMaxString = b.length();
            stringOfMaxLength = b;
        }

        int reminder = 0;
        for (int i = 0; i < lengthOfMaxString; i++) {
            try {
                int sumOfIndex = numbers.indexOf(a.charAt(i)) + numbers.indexOf(b.charAt(i));
                reminder = calculate(numbers, result, reminder, sumOfIndex);
            }catch (IndexOutOfBoundsException e){
                for (int j = i; j < lengthOfMaxString; j++) {
                    int index = numbers.indexOf(stringOfMaxLength.charAt(j));
                    reminder = calculate(numbers, result, reminder, index);
                }
                break;
            }
        }
        if (reminder == 1) result.append(1);
        return result.reverse().toString();
    }

    private static int calculate(String numbers, StringBuilder result, int reminder, int sumOfIndex) {
        if (sumOfIndex + reminder < 36) {
            result.append(numbers.charAt(sumOfIndex + reminder));
            reminder = 0;
        } else {
            result.append(numbers.charAt(sumOfIndex + reminder - 36));
            reminder = 1;
        }
        return reminder;
    }


    public static void main(String[] args) {
        String result = add("", "");
        System.out.println(result);
    }
}