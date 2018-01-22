package training.calculator.calculations;

public class Add implements Calculation {
    @Override
    public int calculate(int first, int second) {
        return first + second;
    }
}
