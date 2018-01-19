import java.util.Random;
import java.util.Scanner;

public class Calculator {
    public static void main (String[] args) {
        System.out.println("Welcome to the calculator!");

        Scanner scanner = new Scanner(System.in);

        // Read two numbers
        System.out.println("Enter two numbers:");
        int first = scanner.nextInt();
        int second = scanner.nextInt();

        // Choose an operation
        System.out.println("Choose an operation (+,-,*):");
        String input = scanner.next();

        // Perform the calculation
        int result;
        switch (input) {
            case "+":
                result = first + second;
                break;
            case "-":
                result = first - second;
                break;
            case "*":
                result = first * second;
                break;
            default:
                throw new IllegalArgumentException("You must enter one of (+,-,*)");
        }

        // Print the calculation and result
        System.out.println(first + input + second + " = "  + result);
    }
}
