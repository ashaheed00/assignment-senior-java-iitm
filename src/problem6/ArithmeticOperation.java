package problem6;

/**
 * The interface for arithmetic operations
 */
public interface ArithmeticOperation {

    /**
     * Perform arithmetic operation on two numbers.
     *
     * @param x First number
     * @param y Second number
     * @return Result of the operation
     */
    double performOperation(double x, double y);

    /**
     * Returns the name of the operation
     *
     * @return the name of the operation
     */
    String getOperationName();
}
