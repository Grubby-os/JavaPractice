import java.util.*;

public class WeeklySpending {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        System.out.println("How much did you spend on each day this week?");
        double[] spending = readSpending(console, days);
        printSpending(days, spending);

        double total = sum(spending);
        int highest = indexOfMax(spending);

        System.out.printf("Total spent:\t$%.2f\nDaily average:\t$%.2f\nHighest Day:\t%s $%.2f", 
        total, (total/days.length), days[highest], spending[highest]);

        console.close();
    }

    public static double[] readSpending(Scanner console, String[] days) {
        double[] spending = new double[days.length];

        for(int i = 0; i < days.length; i++) {
            System.out.print(days[i] + ": ");

            while(!console.hasNextDouble()) {
                System.out.println("Error: please enter a number");
                console.next();
                System.out.print(days[i] + ": ");
            }
            spending[i] = console.nextDouble();
        }
        return spending;
    }

    public static void printSpending(String[] days, double[] spending) {
        System.out.println("Day Amount");
        System.out.println("~~~~~~~~~~");

        for(int i = 0; i < days.length; i++) {
            System.out.println(days[i] + " $" + spending[i]);
        }
    }

    public static double sum(double[] list) {
        double sum = 0;
        for (double n : list) {
            sum += n;
        }
        return sum;
    }

    public static int indexOfMax(double[] list) {
        int maxIndex = 0;

        for (int i = 1; i < list.length; i++) {
            if (list[i] > list[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}