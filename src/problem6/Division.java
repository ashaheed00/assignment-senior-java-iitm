package problem6;

/**
 * implementation of division
 */

public class Division implements ArithmeticOperation {

    /**
     * Performs division of given two numbers
     *
     * @param x First number
     * @param y Second number
     * @return division of two numbers.
     * throws IllegalArgumentException when divided by 0
     */
    @Override
    public double performOperation(double x, double y) {
        if (y == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return x / y;
    }

    @Override
    public String getOperationName() {
        return "Division";
    }
}