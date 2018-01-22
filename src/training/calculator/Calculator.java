package training.calculator;

import training.calculator.calculations.Add;
import training.calculator.calculations.Calculation;
import training.calculator.calculations.Multiply;
import training.calculator.calculations.Subtract;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    private static final String LOG_FILE = "calculator.log";

    public static void main (String[] args) {
        System.out.println("Welcome to the calculator!");
        System.out.println("==========================");

        while (true) {
            // Choose an operation
            Calculation calculation;
            try {
                calculation = chooseCalculation();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            // Choose the numbers
            List<Integer> numbers;
            try {
                numbers = readNumbersFromFile();
            } catch (FileNotFoundException e) {
                System.out.println("Could not find the specified file");
                continue;
            }

            // Calculate the result
            int result = calculate(calculation, numbers);

            // Log and print the result
            try {
                logResult(result);
            } catch (IOException e) {
                // Error writing to log file - ignore
            }

            System.out.println("Result: " + result);

            // Ask if we should continue
            System.out.println("Perform another calculation? (y/n)");
            Scanner scanner = new Scanner(System.in);
            if (!scanner.next().startsWith("y")) {
                break;
            }
        }
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

    private static List<Integer> readNumbersFromFile() throws FileNotFoundException {
        System.out.println("Enter a file:");
        Scanner scanner = new Scanner(System.in);
        String fileString = scanner.next();

        File file = new File(fileString);
        try (Scanner fileScanner = new Scanner(file)) {
            List<Integer> numbers = new ArrayList<>();

            while (fileScanner.hasNextInt()) {
                numbers.add(fileScanner.nextInt());
            }

            return numbers;
        }
    }

    private static int calculate(Calculation calculation, List<Integer> numbers) {
        return numbers
                .stream()
                .reduce((a, b) -> calculation.calculate(a, b))
                .get();
    }

    private static void logResult(int result) throws IOException {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write("Calculated result: " + result + "\n");
        }
    }
}
