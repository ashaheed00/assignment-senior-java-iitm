package problem6;

/**
 * implementation of multiplication
 */
public class Multiplication implements ArithmeticOperation {

    /**
     * Performs multiplication of given two numbers
     *
     * @param x First number
     * @param y Second number
     * @return multiplication of two numbers
     */
    @Override
    public double performOperation(double x, double y) {
        return x * y;
    }

    @Override
    public String getOperationName() {
        return "Multiplication";
    }
}
