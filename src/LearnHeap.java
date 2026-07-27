import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class LearnHeap {
    public static void main(String[] args) {
        // Heap in Java = Priority Queue
        learnPriorityQueue();
    }

    public static PriorityQueue<Integer> resetPriorityQueue() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // Min heap

        pq.offer(5);
        pq.offer(2);
        pq.offer(8);
        pq.offer(1);

        return pq;
    }

    public static void learnPriorityQueue() {
        // Init min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.offer(5); // Add item to PriorityQueue (Auto sort)
        minHeap.offer(2);
        minHeap.offer(8);
        minHeap.offer(1);

        minHeap.poll(); // Get the smallest item in PriorityQueue

        System.out.println(minHeap.peek()); // Peek the smallest item in PriorityQueue

        System.out.println(minHeap.remove(5)); // Remove by object, throw Exception if not found (NoSuchElementException)

        System.out.println(minHeap.element()); // Same as peek, throw Exception if empty

        System.out.println(minHeap.size()); // Print size of PriorityQueue

        System.out.println(minHeap.isEmpty()); // Check if PriorityQueue is empty

        System.out.println(minHeap.contains(2)); // Contains

        minHeap.clear(); // Clear PriorityQueue
        System.out.println(minHeap);

        minHeap = resetPriorityQueue();

        // Traverse with Iterator
        Iterator<Integer> it = minHeap.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // Traverse with for each
        minHeap.forEach(System.out::println);

        minHeap.stream().filter(x -> x > 5).forEach(System.out::println); // Stream

        // Init max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }
}
