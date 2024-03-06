package problem6;

/**
 * implementation of subtraction
 */
public class Subtraction implements ArithmeticOperation {

    /**
     * Performs subtraction of given two numbers
     *
     * @param x First number
     * @param y Second number
     * @return subtraction of two numbers
     */
    @Override
    public double performOperation(double x, double y) {
        return x - y;
    }

    @Override
    public String getOperationName() {
        return "Subtraction";
    }
}