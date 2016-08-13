package goit.task.module10;

import java.io.*;
import java.util.Scanner;

public class InFileEncode {
    public static void toFile(String filenameSource, String filenameDestination, int key) throws IOException {
        Scanner scanner = null;
        FileWriter out = null;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(filenameSource)));
            out = new FileWriter(filenameDestination);
            while (scanner.hasNextLine()) {
                out.write(Cesar.encode(scanner.nextLine(), key));
                out.write("\n");
            }
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    public static void consoleToFile(String message, int key, String file) throws IOException {
        FileWriter out = null;

        try{
            out = new FileWriter(file);
            out.write(Cesar.encode(message, key));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
