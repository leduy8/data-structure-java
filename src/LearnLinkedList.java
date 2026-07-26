import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LearnLinkedList {
    public static void main(String[] args) {
//        learnLinkedList();
        traverseLinkedList();
    }

    public static List<String> resetLinkedList() {
        return new LinkedList<>(List.of("Java", "Spring", "Docker"));
    }

    public static void learnLinkedList() {
        // Init
        List<String> list = new LinkedList<>();

        list.add("Java"); // Add item to end of linked list
        list.add("Spring");
        list.add(1, "Docker");

        System.out.println(list.get(1)); // Get by index

        list.set(1, "AWS");
        System.out.println(list);

        list.remove(1); // Remove by index
        System.out.println(list);
        list.remove("Spring"); // Remove by object
        System.out.println(list);

        System.out.println(list.size()); // Get linked list size

        System.out.println(list.isEmpty()); // Check linked list is empty

        System.out.println(list.contains("Java")); // Contains

        System.out.println(list.indexOf("Java")); // Get index of String

        System.out.println(list.lastIndexOf("Java")); // Get last index of String

        list.clear(); // Clear linked list

        list.addAll(List.of("Java", "Spring", "Docker")); // Add bulk

        list.removeAll(List.of("Java", "Docker")); // Remove bulk
        System.out.println(list);

        list = resetLinkedList();

        list.retainAll(List.of("Java", "Docker"));
        System.out.println(list);

        list = resetLinkedList();

        System.out.println(list.subList(1,3));

        System.out.println(Arrays.toString(list.toArray()));
    }

    public static void traverseLinkedList() {
        List<String> list = resetLinkedList();

        // Option 1: for-each
        for (String s : list) {
            System.out.println(s);
        }

        // Option 2: iterator
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Option 3: Stream
        list.stream().forEach(System.out::println);
    }
}
