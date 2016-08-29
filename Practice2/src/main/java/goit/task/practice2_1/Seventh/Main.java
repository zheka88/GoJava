package goit.task.practice2_1.Seventh;

public class Main {
    public static String binarySum(String s1, String s2) {
        StringBuilder result = new StringBuilder();
        StringBuffer buffer1 = new StringBuffer(s1);
        StringBuffer buffer2 = new StringBuffer(s2);
        int reminder = 0;
        boolean remind = false;
        int sum = 0;
        int lengthDifference;
        String MaxLength;
        String MinLength;
        if (s1.length() >= s2.length()) {
            MaxLength = buffer1.reverse().toString();
            MinLength = buffer2.reverse().toString();
            lengthDifference = s1.length() - s2.length();
            for (int i = lengthDifference; i > 0; i--) {
                MinLength = MinLength.concat("0");
            }
        } else {
            MaxLength = buffer2.reverse().toString();
            MinLength = buffer1.reverse().toString();
            lengthDifference = s2.length() - s1.length();
            for (int i = lengthDifference; i > 0; i--) {
                MinLength.concat("0");
            }
        }
        for (int i = 0; i < MaxLength.length(); i++) {
            try {
                sum = Integer.parseInt(String.valueOf(MaxLength.charAt(i)))
                        + Integer.parseInt(String.valueOf(MinLength.charAt(i))) + reminder;
                if (remind) {
                    reminder -= 1;
                }
                switch (sum){
                    case 0:
                        result.append(sum);
                        break;
                    case 1:
                        result.append(sum);
                        break;
                    case 2:
                        result.append(0);
                        reminder += 1;
                        remind = true;
                        break;
                    case 3:
                        result.append(1);
                        reminder += 1;
                        remind = true;
                        break;
                }
            } catch (Exception e) {
                System.err.println(e);
            }
        }
        if (remind) {
            result.append(1);
        }
        result = result.reverse();
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(binarySum("101", "100"));
    }
}
