import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class LearnStreamAPI {
    public static List<User> resetUser() {
        return List.of(
            new User(1, "Alice", 25, "IT", 2000),
            new User(2, "Bob", 17, "HR", 1000),
            new User(3, "Charlie", 30, "IT", 3000),
            new User(4, "David", 28, "Finance", 4000),
            new User(5, "Alice", 22, "HR", 1500)
        );
    }

    public static void main(String[] args) {
        List<User> users = resetUser();

        users.stream().filter(user -> user.getAge() >= 18).forEach(System.out::println); // Filter

        List<String> names = users.stream().map(user -> user.getName()).toList(); // Map
        System.out.println(names);

        List<List<String>> subjects = List.of(
                List.of("Math", "English"),
                List.of("Java", "Spring"),
                List.of("Docker")
        );
        System.out.println(subjects.stream().map(List::size).toList());
        subjects.stream().flatMap(List::stream).forEach(System.out::println); // Flatmap, flatten into 1 layer list

        users.stream().sorted(Comparator.comparing(User::getAge)).forEach(System.out::println); // Sort asc
        users.stream().sorted(Comparator.comparing(User::getAge).reversed()).forEach(System.out::println); // Sort desc

        users.stream().map(User::getName).distinct().forEach(System.out::println); // Distinct

        users.stream().limit(3).forEach(System.out::println); // Limit output to 3

        users.stream().skip(2).forEach(System.out::println); // Skip first 2

        long totalAdult = users.stream().filter(user -> user.getAge() >= 18).count(); // Count
        System.out.println(totalAdult);

        Optional<User> user = users.stream().filter(u -> u.getDepartment().equals("IT")).findFirst(); // Find first Optional<User> or Optional.empty
        System.out.println(user);

        boolean hasChild = users.stream().anyMatch(u -> u.getAge() < 18); // Any match
        System.out.println(hasChild);

        boolean isAllAdult = users.stream().allMatch(u -> u.getAge() >= 18); // All match
        System.out.println(isAllAdult);

        boolean isNoKid = users.stream().noneMatch(u -> u.getAge() < 15); // None match
        System.out.println(isNoKid);

        Optional<User> youngest = users.stream().min(Comparator.comparing(User::getAge)); // Get min
        System.out.println(youngest);

        Optional<User> oldest = users.stream().max(Comparator.comparing(User::getAge)); // Get max
        System.out.println(oldest);

        Map<String, List<User>> usersByDept = users.stream().collect(Collectors.groupingBy(User::getDepartment)); // Grouping by
        System.out.println(usersByDept);

        Map<Integer, String> map = users.stream().collect(Collectors.toMap(User::getId, User::getName)); // To Map
        System.out.println(map);

        String join1 = users.stream().map(User::getName).collect(Collectors.joining(", "));
        System.out.println(join1);
        String join2 = users.stream().map(User::getName).collect(Collectors.joining(", ", "[", "]"));
        System.out.println(join2);
    }
}







