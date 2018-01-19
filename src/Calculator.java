import java.util.Scanner;

public class Calculator {
    public static void main (String[] args) {
        System.out.println("Welcome to the calculator!");
        System.out.println("==========================");

        // Choose an operation
        Calculation calculation = chooseCalculation();

        // Choose the numbers
        int[] numbers = chooseNumbers();

        // Calculate the result
        int result = calculate(calculation, numbers);

        // Print the result
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

    private static int[] chooseNumbers() {
        // Ask how many numbers
        System.out.println("How many numbers?");
        Scanner scanner = new Scanner(System.in);
        int numberCount = scanner.nextInt();

        // Read the numbers
        int[] numbers = new int[numberCount];
        for (int i = 1; i <= numberCount; i++) {
            System.out.println("Enter number " + i);
            numbers[i - 1] = scanner.nextInt();
        }

        return numbers;
    }

    private static int calculate(Calculation calculation, int[] numbers) {
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result = calculation.calculate(result, numbers[i]);
        }
        return result;
    }
}
