import java.io.*;
import java.util.*;

public class ScoreReport {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        Scanner input = getInput(console);
        processFile(input);
        console.close();
    }

    public static Scanner getInput(Scanner console) throws FileNotFoundException {
        System.out.print("Input file name: ");
        File  inputFile = new File(console.nextLine());
        while (!inputFile.canRead()) {
            System.out.println("File not found, please try again");
            System.out.print("Input file name: ");
            inputFile = new File(console.nextLine());
        }
        System.out.println();
        return new Scanner(inputFile);
    }

    public static void processFile(Scanner input) {
        int counter = 0;

        while (input.hasNextLine()) {
            String text = input.nextLine();
            if (text.trim().length() > 0) {
                reportStudent(text);
                counter++;
            }
        }

        System.out.println();
        System.out.println("Students reported: " + counter);
    }

    public static void reportStudent(String text) {
        Scanner data = new Scanner(text);
        String name = data.next();
        double sum = 0.0;
        while (data.hasNextInt()) {
            sum += data.nextInt();
        }
        double average = sum / 2;
        System.out.println(name + " " + average);
        data.close();
    }
}