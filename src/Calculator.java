import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    public static void main (String[] args) {
        System.out.println("Welcome to the calculator!");
        System.out.println("==========================");

        // Choose an operation
        Calculation calculation = chooseCalculation();

        // Choose the numbers
        List<Integer> numbers = chooseNumbers();

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

    private static List<Integer> chooseNumbers() {
        // Enter the numbers
        System.out.println("Enter a number:");
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        while(scanner.hasNextInt()) {
            numbers.add(scanner.nextInt());
            System.out.println("Enter another number or 'done':");
        }

        return numbers;
    }

    private static int calculate(Calculation calculation, List<Integer> numbers) {
        return numbers
                .stream()
                .reduce((a, b) -> calculation.calculate(a, b))
                .get();
    }
}
