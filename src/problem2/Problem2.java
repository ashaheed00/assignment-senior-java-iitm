package problem2;

/**
 * This is a test class for our custom Stack class
 */
public class Problem2 {
    public static void main(String[] args) {
        StackUsingQueues<Integer> stack = new StackUsingQueues<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(null);
        stack.push(4);

        System.out.println("Top element: " + stack.top());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Top element: " + stack.top());
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
