package goit.task.module10;

import java.io.*;
import java.util.Scanner;

public class FromFileDecode {
    public static void fromFile(String filenameSource, int key, String filenameOut) throws IOException {
        Scanner scanner = null;
        FileWriter out = null;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(filenameSource)));
            out = new FileWriter(filenameOut);
            while (scanner.hasNextLine()) {
                out.write(Cesar.decode(scanner.nextLine(), key));
                out.write("\n");
            }
        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (IOException e) {
            e.getMessage();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}

