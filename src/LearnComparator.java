import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LearnComparator {
    public static List<User> resetUser() {
        List<User> list = new ArrayList<>();
        list.add(new User(1, "Alice", 25, "IT", 2000));
        list.add(new User(2, "Bob", 17, "HR", 1000));
        list.add(new User(3, "Charlie", 30, "IT", 3000));
        list.add(new User(4, "David", 28, "Finance", 4000));
        list.add(new User(5, "Alice", 22, "HR", 1500));
        return list;
    }

    public static List<User> resetUserWithNull() {
        List<User> list = new ArrayList<>();
        list.add(new User(1, "Alice", 25, "IT", 2000));
        list.add(null);
        list.add(new User(2, "Bob", 17, "HR", 1000));
        return list;
    }

    public static void main(String[] args) {
        List<User> users = resetUser();
        System.out.println("Original array list: " + users);

        users.sort(Comparator.comparing(User::getAge)); // Using Comparator with comparing
        System.out.println(users);

        users = resetUser();

        users.sort((a,b) -> Integer.compare(a.getAge(), b.getAge())); // Lambda
        System.out.println(users);

        users = resetUser();

        users.sort(Comparator.comparing(User::getAge).reversed()); // Reversed
        System.out.println(users);

        users = resetUser();

        users.sort(Comparator.comparingInt(User::getAge)); // Faster than comparing, remove boxing/unboxing (int <-> Integer)
        // Other variants:
        // comparingInt
        // comparingLong
        // comparingDouble
        System.out.println(users);

        users = resetUser();

        users.sort(Comparator.comparing(User::getDepartment).thenComparing(User::getName)); // Comparing more than once
        // Other variants:
        // thenComparingInt
        // thenComparingLong
        // thenComparingDouble
        System.out.println(users);

        List<User> list = resetUserWithNull();
        list.sort(Comparator.nullsFirst(
                Comparator.comparing(User::getName, Comparator.nullsFirst(String::compareTo)) // nullFirst will put null to first then compare
        ));
        System.out.println(list);

        list = resetUserWithNull();
        list.sort(Comparator.nullsLast(
                Comparator.comparing(User::getName, Comparator.nullsLast(String::compareTo)) // nullLast will put null to last then compare
        ));
        System.out.println(list);

        List<String> names = List.of("Charlie","Alice","Bob");
        System.out.println(names.stream().sorted(Comparator.naturalOrder()).toList()); // Sort by natural order
        System.out.println(names.stream().sorted(Comparator.reverseOrder()).toList()); // Sort by reverse order

        users = resetUser();

        users.sort(Comparator.comparing(User::getName, String.CASE_INSENSITIVE_ORDER)); // Sort with String
        System.out.println(users);

        users = resetUser();

        users.sort(Comparator.comparingInt(u -> u.getName().length()));
        System.out.println(users);

        users = resetUser();

        users.sort(
            Comparator.comparing(User::getDepartment)
                .thenComparing(Comparator.comparingInt(User::getAge).reversed())
                .thenComparingDouble(User::getSalary)
                .thenComparing(User::getName)
        );
        System.out.println(users);
    }
}







