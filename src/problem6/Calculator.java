package problem6;

/**
 * Calculator class using Strategy pattern.
 * calculates based on certain operation set
 */
public class Calculator {
    private ArithmeticOperation operation;

    /**
     * Set the arithmetic operation to be performed.
     *
     * @param operation The arithmetic operation
     */
    public void setOperation(ArithmeticOperation operation) {
        this.operation = operation;
    }

    /**
     * Perform calculation using the set operation.
     *
     * @param x First number
     * @param y Second number
     * @return Result of the calculation
     * throws IllegalStateException if the operation is not set
     */
    public double calculate(double x, double y) {
        if (this.operation == null) {
            throw new IllegalStateException("Please set operation type before calling this method");
        }
        return operation.performOperation(x, y);
    }

    /**
     * Perform calculation using the given operation
     *
     * @param operation given operation
     * @param x         First number
     * @param y         Second number
     * @return Result of the calculation
     */
    public double calculate(ArithmeticOperation operation, double x, double y) {
        this.operation = operation;
        return operation.performOperation(x, y);
    }
}