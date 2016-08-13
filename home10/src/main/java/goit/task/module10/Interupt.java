package goit.task.module10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Interupt {
    public static void run() throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int choise = 0;
            System.out.println("Choose the operation\n1. Encode text message\t\t2. Decode your text message\t\t3. Exit");
            choise = Integer.parseInt(reader.readLine());
            if (choise == 1) {
                runEncode();
            }
            if (choise == 2) {
                runDecode();
            }
            if (choise == 3) {
                System.exit(1);
            }
            if (choise != 1 && choise != 2) {
                throw new IllegalArgumentException("Wrong input!!!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
            run();
        }
        run();
    }

    public static void runEncode() throws IOException {
        try {
            int key = 0;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please choose the way you want to input your data:" +
                    "\n1: Filename.txt from the program root directory\n" +
                    "2: Input text message in console");
            int choise = Integer.parseInt(reader.readLine());
            if (choise == 1) {
                System.out.println("Please enter a corect filename.txt:");
                String fileSorce = reader.readLine();
                System.out.println("Ente a key:");
                key = Integer.parseInt(reader.readLine());
                System.out.println("Please enter a destination filename.txt:");
                String fileOut = reader.readLine();
                InFileEncode.toFile(fileSorce, fileOut, key);
                System.out.println("Job well done!!!");
            }
            if (choise == 2) {
                System.out.println("Enter your text message:");
                String message = reader.readLine();
                System.out.println("Enter a key:");
                key = Integer.parseInt(reader.readLine());
                System.out.println("and output filename.txt:");
                String outFile = reader.readLine();
                InFileEncode.consoleToFile(message, key, outFile);
                System.out.println("Job well done!!!");
            }
            if (choise != 1 && choise != 2) {
                throw new IllegalArgumentException("Wrong input!!!");
            }
        } catch (NumberFormatException ex){
            throw new RuntimeException();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
            runEncode();
        }
    }

    public static void runDecode() throws IOException {
        int key = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a filename.txt which contains your ciphered message:");
        String filesource = reader.readLine();
        System.out.println("Now enter a cipher key:");
        key = Integer.parseInt(reader.readLine());
        System.out.println("Enter a destination filename.txt:");
        String fileOut = reader.readLine();
        FromFileDecode.fromFile(filesource, key, fileOut);
        System.out.println("Job well done!!!");
    }
}
