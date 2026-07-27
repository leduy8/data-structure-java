import java.util.*;

public class LearnStackQueue {
    public static void main(String[] args) {
        learnStack();
        learnQueue();
    }

    public static void learnStack() {
        // Init
        // Stack works in LIFO (Last in First out)
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(10); // Push to stack
        stack.push(20);
        stack.push(30);

        stack.pop(); // Pop the item in the top of stack

        System.out.println(stack.peek()); // Peek the item in the top of stack

        System.out.println(stack.isEmpty()); // Check stack is empty

        System.out.println(stack.size()); // Size of stack

        System.out.println(stack.contains(10)); // Contains

        stack.clear(); // Clear stack
        System.out.println(stack);
    }

    public static void learnQueue() {
        // Init
        // Stack works in FIFO (First in First out)
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(10); // Add item to queue
        queue.offer(20);
        queue.offer(30);

        queue.poll(); // Remove first item in the queue (10)

        System.out.println(queue.peek()); // Peek the item in the first of queue currently

        System.out.println(queue.isEmpty()); // Check if queue is empty

        System.out.println(queue.size()); // Check size of queue

        System.out.println(queue.contains(20)); // Contains

        queue.clear();
        System.out.println(queue);
    }
}
