import java.util.*;

public class MovieSeats {
    public static final int TOTAL_ROW = 4;
    public static final int TOTAL_COL = 6;
    public static final int STOP = 0;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        boolean[][] taken = new boolean[TOTAL_ROW][TOTAL_COL]; //all seats are open (initialized to false)

        System.out.println("Reserve seats in a theater with " + TOTAL_ROW + " rows of " + TOTAL_COL + " seats.");
        showSeats(taken);

        System.out.print("Row to reserve (" + STOP + " to finish): ");
        int row = console.nextInt(); // priming read
        while (row != STOP) { // sentinel loop: stop when the row is 0
            System.out.print("Seat number: ");
            int seat = console.nextInt();

            if (!isValidSeat(taken, row, seat)) {
                System.out.println("There is no such seat.");
            } else if (taken[row - 1][seat - 1]) {
                System.out.println("Sorry, that seat is already taken.");
            } else {
                taken[row - 1][seat - 1] = true;
                System.out.println("Reserved!");
            }
            showSeats(taken);

            System.out.print("Row to reserve (0 to finish): ");
            row = console.nextInt(); // read again
        }

        int total = taken.length * taken[0].length;
        System.out.println("Seats taken: " + countTaken(taken) + " of " + total);

        console.close();
    }

    public static void showSeats(boolean[][] taken) {
        for (int r = 0; r < taken.length; r++) {
            System.out.print("Row " + (r + 1) + ": ");

            for (int c = 0; c < taken[r].length; c++) {
                if (taken[r][c]) {
                    System.out.print("X");
                } else {
                    System.out.print("O");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
 
    public static int countTaken(boolean[][] taken) {
        int counter = 0;

        for (int r = 0; r < taken.length; r++) {
            for (int c = 0; c < taken[r].length; c++) {
                if(taken[r][c]) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static boolean isValidSeat(boolean[][] taken, int row, int seat) {
        return row >= 1 && row <= taken.length && seat >= 1 && seat <= taken[row - 1].length;
    }
}
