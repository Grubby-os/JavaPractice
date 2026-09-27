import java.util.*;

public class Savings {
    public static final double INTEREST_RATE = 0.05;
    public static final int YEAR_WIDTH = 6;
    public static final int MONEY_WIDTH = 16;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("This program will calculate savings for you!");
        System.out.println();

        System.out.println("What is your initial deposit?: "); //prompt
        double iD = console.nextDouble();

        System.out.println("What is you annual deposit?: "); //prompt
        double aD = console.nextDouble();

        System.out.println("How many years are you saving for?: "); //prompt
        int years = console.nextInt();

        printTable(iD, aD, INTEREST_RATE, years); //call printTable method with the given info

        console.close();
    }

    public static void printTable(double initialDeposit, double annualDeposit, double rate, int years) {
        System.out.println("year  current balance interest        deposit         new balance");
        double balance = initialDeposit;
        double interest = 0;

        for(int i = 1; i <= years; i++) {
            interest = balance * rate;
            printField(String.valueOf(i), YEAR_WIDTH); // prints the year
            printField(String.valueOf(round2(balance)), MONEY_WIDTH); // prints the initial balance
            printField(String.valueOf(round2(interest)), MONEY_WIDTH); // prints what this years interest would be
            printField(String.valueOf(annualDeposit), MONEY_WIDTH); // prints the annual deposit

            balance += interest;

            if (i > 1) { // simple if statement to check if its past year 1 to add the annual deposit
                balance += annualDeposit;
            }

            printField(String.valueOf(round2(balance)), MONEY_WIDTH); // prints the new balance
            System.out.println(); // start next line
        }

    }

    public static void printField(String text, int width) {
        System.out.print(text);
        for(int i = 1; i <= width - text.length(); i++) // the number of spaces should be the width - the length of the text to fill in the gaps
            System.out.print(" ");
    }

    public static double round2(double n) {
        return (int) (n * 100.0 + 0.5) / 100;
    }
}