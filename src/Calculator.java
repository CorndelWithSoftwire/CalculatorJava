import java.util.Scanner;

public class Calculator {
    public static void main (String[] args) {
        System.out.println("Welcome to the calculator!");

        // Read two numbers
        System.out.println("Enter two numbers:");
        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        int second = scanner.nextInt();

        // Choose an operation
        Calculation calculation = chooseCalculation();

        // Calculate and print the result
        int result = calculation.calculate(first, second);
        System.out.println("Result: " + result);
    }

    private static Calculation chooseCalculation() {
        System.out.println("Choose an operation (+,-,*):");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        switch (input) {
            case "+": return new Add();
            case "-": return new Subtract();
            case "*": return new Multiply();
            default:
                throw new IllegalArgumentException("You must enter one of (+,-,*)");
        }
    }
}
