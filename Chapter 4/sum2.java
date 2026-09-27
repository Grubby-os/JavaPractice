import java.util.*;

public class sum2 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = console.nextInt();
        int sum = sumTo(num);
        System.out.println("Sum from 1 to " + num + " is " + sum);
        console.close();
    }

    public static int sumTo(int num) {
        int sum = 0;
        for(int i = 1; i <= num; i++) {
            sum += i;
        }
        return sum;
    }
}