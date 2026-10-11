import java.io.*;
import java.util.*;

public class ScoreWriter {
    public static final String OUTPUT_FILE = "Assignment 5/scores.txt";
    public static final String QUIT = "quit";

    public static void main(String[] args) throws FileNotFoundException {
        printIntro();

        Scanner console = new Scanner(System.in);
        PrintStream output = new PrintStream(new File(OUTPUT_FILE));

        int count = 0;
        String name = getName(console);
        while (!name.equalsIgnoreCase(QUIT)) {
            writeStudent(console, output, name);
            count++;
            name = getName(console);
        }

        System.out.println();
        System.out.println(count + " student record(s) written to " + OUTPUT_FILE);
    }

    public static void printIntro() {
        System.out.println("This program records each student's midterm and final exam scores in " + OUTPUT_FILE + ".");
        System.out.println("Enter each student's name (one word), then the two scores (0-100).");
        System.out.println("Enter '" + QUIT + "' as a name when you are finished.");
        System.out.println();
    }

    public static String getName(Scanner console) {
        System.out.print("Student name (or " + QUIT + "): ");
        return console.next();
    }

    public static void writeStudent(Scanner console, PrintStream output, String name) {
        int midTerm = getScore(console, "Midterm exam score for " + name + ": ");
        int finalExam = getScore(console, "Final exam score for " + name + ": ");

        output.println(name + " " + midTerm + " " + finalExam);
    }

    public static int getScore(Scanner console, String prompt) {
        System.out.print(prompt);

        while (!console.hasNextInt()) {
            System.out.println("ERROR: please enter an integer (0-100)");
            console.next();
            System.out.print(prompt);
        }

        int test = console.nextInt();

        while (!isValidScore(test)) {
            System.out.println("ERROR: please enter an integer (0-100)");
            System.out.print(prompt);
            test = console.nextInt();
        }

        return test;
    }

    public static boolean isValidScore(int score) {
        return score >= 0 && score <= 100;
    }
    
}
