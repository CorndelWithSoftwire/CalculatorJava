import java.util.Random;
import java.util.Scanner;

public class Calculator {
    public static void main (String[] args) {
        System.out.println("Welcome to the calculator!");

        // Generate two random numbers
        Random random = new Random();
        int first = random.nextInt(100);
        int second = random.nextInt(100);

        System.out.println("First number: " + first);
        System.out.println("Second number: " + second);

        // Choose an operation
        System.out.println("Choose an operation (+,-,*):");
        Scanner scanner = new Scanner(System.in);
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

        // Print the result
        System.out.println("Result: " + result);
    }
}
