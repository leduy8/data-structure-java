import java.util.*;

public class LearnSet {
    public static void main(String[] args) {
        learnHashSet();
        convertHashSet();
        setOperations();
    }

    public static Set<String> resetSet() {
        Set<String> set = new HashSet<>();
        set.add("Java");
        set.add("Spring");
        set.add("Docker");
        return set;
    }

    public static void learnHashSet() {
        // Init
        Set<String> set = new HashSet<>();

        set.add("Java"); // Add item to set
        set.add("Spring");
        set.add("Docker");
        System.out.println(set);

        set.add("Java"); // Every item in set is distinct
        System.out.println(set);

        set.remove("Spring"); // Remove item from a set
        System.out.println(set);

        System.out.println(set.contains("Java")); // Contains

        System.out.println(set.size()); // Size of set

        System.out.println(set.isEmpty()); // Check if size is empty

        set.clear(); // Clear set
        System.out.println(set);

        set.addAll(List.of("Java", "Spring", "Docker")); // Add bulk

        set.removeAll(List.of("Java", "Docker")); // Remove bulk

        set = resetSet();

        set.retainAll(List.of("Java", "Docker")); // Intersection
        System.out.println(set);

        set = resetSet();

        System.out.println(set.containsAll(List.of("Java", "Spring"))); // Contains multiple items

        // Print using Iterator
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // Print using for loops
        for (String s : set) {
            System.out.println(s);
        }

        set.forEach(System.out::println); // Print using for each

        System.out.println(set.stream().filter(s -> s.length() > 5).toList()); // Stream
    }

    public static void convertHashSet() {
        // HashSet <-> ArrayList
        Set<String> set = resetSet();
        List<String> list = new ArrayList<>(set);
        System.out.println(list);
        System.out.println(list.getClass().getName());

        // ArrayList <-> HashSet
        List<String> list2 = new ArrayList<>();
        list2.add("Java");
        list2.add("Spring Boot");
        Set<String> set2 = new HashSet<>(list2);
        System.out.println(set2);
        System.out.println(set2.getClass().getName());

        // HashSet <-> Array
        Set<String> set3 = resetSet();
        String[] arr = set3.toArray(new String[0]);
        System.out.println(Arrays.toString(arr));
        System.out.println(arr.getClass().getName());
    }

    public static void setOperations() {
        // Union
        Set<Integer> a = new HashSet<>(List.of(1,2,3));
        Set<Integer> b = new HashSet<>(List.of(4,5,6));
        Set<Integer> union = new HashSet<>(a);
        union.addAll(b);
        System.out.println(union);

        // Intersection
        Set<Integer> c = new HashSet<>(List.of(1,2,3));
        Set<Integer> d = new HashSet<>(List.of(4,5,6));
        Set<Integer> intersection = new HashSet<>(c);
        intersection.retainAll(d);
        System.out.println(intersection);

        // Difference
        Set<Integer> e = new HashSet<>(List.of(1,2,3));
        Set<Integer> f = new HashSet<>(List.of(4,5,6));
        Set<Integer> difference = new HashSet<>(e);
        difference.removeAll(f);
        System.out.println(difference);
    }
}
