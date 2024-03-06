package problem6;

/**
 * implementation of addition
 */
class Addition implements ArithmeticOperation {

    /**
     * Performs addition of given two numbers
     *
     * @param x First number
     * @param y Second number
     * @return sum of two numbers
     */
    @Override
    public double performOperation(double x, double y) {
        return x + y;
    }

    @Override
    public String getOperationName() {
        return "Addition";
    }
}
