import java.util.*;

public class temperatureImproved {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        getTemp(console);
        
        console.close();
    }

    public static void getTemp(Scanner console) {
        double convert;

        System.out.print("Enter the temperature value: "); // prompt for temperature value
        double temp = console.nextDouble();
        System.out.print("Enter the type of temperature (C for Celcius - F for Fahrenheit): "); // promt for F or C
        char type = console.next().charAt(0);

        if (type == 'C' || type == 'c') { // checks for Celcius then validates it's > absolute zero before conversion
            if (temp < -273.15) {
                throw new IllegalArgumentException("Temperature cannot be below absolute zero (-273.15\u00B0C)");
            }
            convert = ctof(temp);
            System.out.printf("%.2f\u00B0C is equal to %.2f\u00B0F\n", temp, convert);
        } else if (type == 'F' || type == 'f') { // checks for Fahrenheit then validates it's > absolute zero before conversion
            if (temp < -459.67) {
                throw new IllegalArgumentException("Temperature cannot be below absolute zero (-459.67\u00B0F)");
            }
            convert = ftoc(temp);
            System.out.printf("%.2f\u00B0F is equal to %.2f\u00B0C\n", temp, convert);
        } else {
            throw new IllegalArgumentException("Please enter F or C"); // exception if type is not F or C
        }
    }

    public static double ftoc(double tempf) { // calculation method
        double tempc = (tempf - 32) * 5 / 9;
        return tempc;
    }

    public static double ctof(double tempc) { // calculation method
        double tempf = (tempc * (9/5)) + 32;
        return tempf;
    }
}