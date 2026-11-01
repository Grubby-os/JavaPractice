/* This program utilizes the book.java class and the books.csv file and checks how many 
books have less than the low threshold (2) of books. It then prints out those book titles
and how many copies are still available. This program does all of the printing since 
book has a toString() method. Since this uses a csv as the input file, the useDelimiter method was
utilized with the delimited being the comma character, this way the program splits between each comma,
instead of the default space character */

import java.io.*;
import java.util.*;

public class LibraryMain {
    public static final int MAX_BOOKS = 50;
    public static final int LOW_THRESHOLD = 2;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        giveIntro();

        Scanner input = getInput(console);
        Book[] books = new Book[MAX_BOOKS];
        int count = readBooks(input, books);

        printLowBooks(books, count);

        input.close();
        console.close();
    }

    public static void giveIntro() {
        System.out.println("This program reads a library catalogue file and lists the books that are running low.");
        System.out.println("A book is low when fewer than " + LOW_THRESHOLD + " copies are available.");
        System.out.println();
    }

    public static Scanner getInput(Scanner console) throws FileNotFoundException {
        System.out.print("Catalog file name?: ");
        String fileName = console.nextLine();
        File inputFile = new File(fileName);

        while (!inputFile.canRead()) {
            System.out.println("File not found. Try again");
            System.out.print("Catalog file name?: ");
            fileName = console.nextLine();
            inputFile = new File(fileName);
        }

        return new Scanner(inputFile);
    }

    public static int readBooks(Scanner input, Book[] books) {
        if (input.hasNextLine()) {
            input.nextLine();
        }

        int count = 0;
        while (count < books.length && input.hasNextLine()) {
            String line = input.nextLine();
            if (line.trim().length() > 0) {
                books[count] = readBook(line);
                count++;
            }
        }
        return count;
    }

    public static Book readBook(String line) {
        Scanner data = new Scanner(line);
        data.useDelimiter(",");

        String title = data.next();
        int totalCopies = data.nextInt();
        int checkedOut = data.nextInt();
        data.close();

        return new Book(title, totalCopies, checkedOut);
    }

    public static void printLowBooks(Book[] books, int count) {
        System.out.println("Books running low: ");
        int lowCount = 0;

        for (int i = 0; i < count; i++) {
            if (books[i].getAvailable() < LOW_THRESHOLD) {
                System.out.println(" " + books[i]);
                lowCount++;
            }
        }

        if (lowCount == 0) {
            System.out.println("None.");
        }
        System.out.println();
        System.out.println(count + " books in the catalogue, " + lowCount + " running low.");
    }
}