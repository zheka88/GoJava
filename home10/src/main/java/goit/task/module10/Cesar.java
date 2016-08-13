package goit.task.module10;

public class Cesar {
    private static final int ABC_QUANTITY = 26;

    public static String decode(String enc, int offset) {
        return encode(enc, ABC_QUANTITY - offset);
    }

    public static String encode(String enc, int offset) {
        offset = offset % ABC_QUANTITY + ABC_QUANTITY;
        StringBuilder encoded = new StringBuilder();
        for (char i : enc.toCharArray()) {
            if (Character.isLetter(i)) {
                if (Character.isUpperCase(i)) {
                    encoded.append((char) ('A' + (i - 'A' + offset) % ABC_QUANTITY));
                } else {
                    encoded.append((char) ('a' + (i - 'a' + offset) % ABC_QUANTITY));
                }
            } else {
                encoded.append(i);
            }
        }
        return encoded.toString();
    }
}
