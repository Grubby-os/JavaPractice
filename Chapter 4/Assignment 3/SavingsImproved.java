import java.util.*;

public class SavingsImproved {
    public static final double INTEREST_RATE = 0.05;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("This program will calculate savings for you!");
        System.out.println();

        System.out.print("What is your initial deposit?: "); //prompt
        double iD = console.nextDouble();

        System.out.print("What is you annual deposit?: "); //prompt
        double aD = console.nextDouble();

        System.out.print("How many years are you saving for?: "); //prompt
        int years = console.nextInt();

        checkValues(iD, aD, years);

        double totalInt = printTable(iD, aD, INTEREST_RATE, years); //call printTable method with the given info 
        System.out.printf("Total Interest: %.2f\n", totalInt);

        console.close();
    }

    public static double printTable(double initialDeposit, double annualDeposit, double rate, int years) {
        System.out.println("year  current balance interest        deposit         new balance");
        double balance = initialDeposit; double interest = 0; double totalInterest = 0; double Zero = 0.0;

        for(int i = 1; i <= years; i++) {
            interest = balance * rate;
            System.out.printf("%-6s", i);
            System.out.printf("%-16.2f", balance); // prints the initial balance
            System.out.printf("%-16.2f", interest); // prints what this years interest would be
            
            if (i == 1) {
                System.out.printf("%-16.1f", Zero);
            } else {
                System.out.printf("%-16.1f", annualDeposit); // prints the annual deposit
            }
            balance += interest;
            totalInterest += interest;
            if (i > 1) { // simple if statement to check if its past year 1 to add the annual deposit
                balance += annualDeposit;
            }
            System.out.printf("%-16.2f", balance); // prints the new balance
            System.out.println(); // start next line
        }
        return totalInterest; // return the running total value
    }

    public static void checkValues(double initialDeposit, double annualDeposit, int years) {
        if (initialDeposit < 0) {
            throw new IllegalArgumentException("Initial deposit cannot be negative");
        }

        if (annualDeposit < 0) {
            throw new IllegalArgumentException("Annual Deposit cannot be negative");
        }

        if (years <= 0) {
            throw new IllegalArgumentException("Number of years must be positive");
        }
    }

}