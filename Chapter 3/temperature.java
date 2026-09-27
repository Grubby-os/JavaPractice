import java.util.*;

public class temperature {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Please enter a temperature in F to convert to C: ");
        double tempf = console.nextDouble();

        double tempc = 0.0;
        tempc = ftoc(tempf);
        System.out.println("Temperature in C is: " + tempc);
        console.close();
    }

    public static double ftoc(double tempf) {
        double tempc = (tempf - 32) * 5 / 9;
        return tempc;
    }
}