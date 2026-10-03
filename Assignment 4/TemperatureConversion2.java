/* This program takes user input temperature type and temperature validating both before 
returning the calculated result from Fahrenheit to Celcius or vice versa */

import java.util.Scanner;

public class TemperatureConversion2 {
    public static final double ABSOLUTE_ZERO_C = -273.15;
    public static final double ABSOLUTE_ZERO_F = -459.67;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        char type = getTemperatureType(console,
                "Enter the type of temperature (C for Celsius, F for Fahrenheit): ");
        double temperature = getTemperature(console, type);

        printConversion(type, temperature);

        console.close();
    }

    public static double getTemperature(Scanner console, char type) {
        double temperature = getDouble(console, "Enter a temperature: ");

        if (type == 'C') {
            while (temperature < ABSOLUTE_ZERO_C) {
                System.out.println("Temperature is below absolute zero: " + ABSOLUTE_ZERO_C + "C");
                System.out.print("Please try again. ");
                temperature = getDouble(console, "Enter a temperature in C: ");
            }
            return temperature;
        } else {
            while (temperature < ABSOLUTE_ZERO_F) {
                System.out.println("Temperature is below absolute zero: " + ABSOLUTE_ZERO_F + "F");
                System.out.print("Please try again. ");
                temperature = getDouble(console, "Enter a temperature in F: ");
            }
            return temperature;
        }

    }

    public static double getDouble(Scanner console, String prompt) {
        System.out.print(prompt);
        while (!console.hasNextDouble()) {
            console.next();
            System.out.println("Not a number; try again.");
            System.out.print(prompt);
        }
        return console.nextDouble();
    }

    public static char getTemperatureType(Scanner console, String prompt) {
        char type = '\0';
        do {
            System.out.print(prompt);
            String token = console.next();

            if (token.length() == 1) {
                type = token.toUpperCase().charAt(0);
            } else {
                System.out.println("Please enter 'C' or 'F' only.");
            }

            if (type != 'C' && type != 'F') {
                System.out.println("Invalid type; please enter 'C' or 'F'.");
            }
        } while (type != 'C' && type != 'F');
        return type;
    }

    public static void printConversion(char type, double temperature) {
        double newTemp = 0.0;
        if (type == 'C') {
            newTemp = (temperature * (9.0/5.0)) + 32;
            System.out.printf("%.2f\u00B0C is equal to %.2f\u00B0F", temperature, newTemp);
        } else {
            newTemp = ((temperature - 32) * 5.0 / 9.0);
            System.out.printf("%.2f\u00B0F is equal to %.2f\u00B0C", temperature, newTemp);
        }
    }
}