import java.util.*;

public class printOddNum {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter integer 1: ");
        int n1 = console.nextInt();
        System.out.print("Enter integer 2: ");
        int n2 = console.nextInt();
        System.out.print("Enter integer 3: ");
        int n3 = console.nextInt();

        printNumOdd(n1, n2, n3);
        console.close();
    }

    public static void printNumOdd(int n1, int n2, int n3) {
        int count = 0;
        if (n1 % 2 != 0) {
            count ++;
        }

        if (n2 % 2 != 0) {
            count ++;
        }

        if (n3 % 2 != 0) {
            count ++;
        }
        System.out.println(count + " of the 3 numbers are odd");
    }
}