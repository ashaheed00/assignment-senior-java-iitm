package problem6;

import java.util.Scanner;

/**
 * This is runner class for Calculator app
 */
public class Problem6 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first number:");
        double x = scanner.nextDouble();

        System.out.println("Enter second number:");
        double y = scanner.nextDouble();

        System.out.println("Enter operation (+, -, *, /):");
        char op = scanner.next().charAt(0);

        ArithmeticOperation operation;
        switch (op) {
            case '+':
                operation = new Addition();
                break;
            case '-':
                operation = new Subtraction();
                break;
            case '*':
                operation = new Multiplication();
                break;
            case '/':
                operation = new Division();
                break;
            default:
                System.out.println("Invalid operation");
                return;
        }

        calculator.setOperation(operation);
        try {
            //Addition
            double result = calculator.calculate(x, y);
            System.out.println("Result of " + operation.getOperationName() + " : " + result);

            //Multiplication using the other calculate method
            calculator.calculate(new Multiplication(), x, y);

        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
