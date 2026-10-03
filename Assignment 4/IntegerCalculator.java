/* This is a simple calculator program that lets you take any two integers
and you are able to add them, subtract them, multiply them, or divide them */

/* This program makes use of the fencepost-while-loop for validation
preventing the program from shutting down after a bad input*/

import java.util.Scanner;

public class IntegerCalculator {
    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);

        giveIntro();

        char operand = getOperation(console,
                "What operation would you like to perform? (A)dd (S)ubtract (M)ultiply or (D)ivide: ");
        
        calculate(console, operand);
    
        console.close();
    }

    public static void giveIntro() {
        System.out.println("This program allows you to perform basic calculations " +
            "on any 2 integers of your choosing");
        System.out.println("");
    }

    public static char getOperation(Scanner console, String prompt) {
        char operation = '\0';
        do {
            System.out.print(prompt);
            String token = console.next();

            if (token.length() == 1) {
                operation = token.toUpperCase().charAt(0);
            } else {
                System.out.println("Please enter a single character only.");
            }

            if (operation != 'A' && operation != 'S' && operation != 'M' && operation != 'D') {
                System.out.println("Please enter a char in the parenthesis: (A)dd (S)ubtract (M)ultiply or (D)ivide.");
            }
        } while (operation != 'A' && operation != 'S' && operation != 'M' && operation != 'D');
        return operation;
    }
    
    public static int getInt(Scanner console, String prompt) {
        System.out.print(prompt);
        while (!console.hasNextInt()) {
            console.next();
            System.out.println("Not an integer; please try again.");
            System.out.print(prompt);
        }
        return console.nextInt();
    }

    public static void calculate(Scanner console, char operand) {
        int num1 =  getInt(console, "Enter the first number for your calculation: ");
        double num2 =  getInt(console, "Enter the second number for your calculation: ");
        double result;

        if (operand == 'A') {
            result = num1 + num2;
            System.out.printf("The sum of %d and %.0f is %.0f.", num1, num2, result);
        } else if (operand == 'S') {
            result = num1 - num2;
            System.out.printf("The difference between %d and %.0f is %.0f", num1, num2, result);
        } else if (operand == 'M') {
            result = num1 * num2;
            System.out.printf("The product of %d and %.0f is %.0f.", num1, num2, result);
        } else {
            result = num1 / num2;
            System.out.printf("The quotient of %d and %.0f is %.2f.", num1, num2, result);
        }
    }

}