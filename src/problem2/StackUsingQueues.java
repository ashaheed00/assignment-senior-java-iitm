package problem2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A generic implementation of a stack using two queues.
 *
 * @param <T> the type of elements stored in the stack
 */
public class StackUsingQueues<T> {
    private Queue<T> queue1;
    private Queue<T> queue2;

    /**
     * Constructs a new empty stack.
     */
    public StackUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /**
     * Pushes an element onto the top of this stack.
     *
     * @param data the element to push
     */
    public void push(T data) {
        queue1.add(data);
    }

    /**
     * Removes the element at the top of this stack and returns it.
     *
     * @return the element removed from the top of the stack
     */
    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }

        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }

        T poppedElement = queue1.poll();

        Queue<T> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return poppedElement;
    }

    /**
     * Returns the element at the top of this stack without removing it.
     *
     * @return the element at the top of the stack
     */
    public T top() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }

        T topElement = null;
        while (!queue1.isEmpty()) {
            topElement = queue1.poll();
            queue2.add(topElement);
        }

        Queue<T> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return queue1.isEmpty();
    }
}
