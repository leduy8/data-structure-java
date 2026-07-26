import java.util.Arrays;

public class LearnString {
    public static void main(String[] args) {
        learnString123();
        learnStringBuilder123();
    }

    public static void learnString123() {
        // Init String
        String a = "Hello"; // Most common
        String b = new String("Hello");

        System.out.println(a.length()); // Get String length

        System.out.println("".isEmpty()); // Check empty String
        System.out.println("  ".isBlank()); // Check String is blank
        // empty != blank. Empty must be "", blank can be "" or "  "

        System.out.println(a.charAt(1)); // Get char at index

        System.out.println("Java".equals("Java")); // Check String equal-ness

        System.out.println("Java".equalsIgnoreCase("JAVA")); // Check String equal-ness ignore case

        System.out.println("Apple".compareTo("Banana")); // Compare to check each character in ASCII table

        System.out.println("java".compareToIgnoreCase("JAVA")); // Compare to check each character in ASCII table ignore case

        System.out.println("Hello World".contains("Hello")); // Check string contains substring

        System.out.println("Spring Boot".startsWith("Spring")); // Check string starts with

        System.out.println("Spring Boot".endsWith("Boot")); // Check string ends with

        System.out.println("Spring".indexOf("r")); // Returns first index of char

        System.out.println("java".lastIndexOf("a")); // Returns last index of char

        System.out.println("Spring".substring(1));

        String[] arr = "A,B,C".split(","); // Split uses Regex
        System.out.println(Arrays.toString(arr));
        String[] arr2 = "Master.Mind.123".split("\\.");
        System.out.println(Arrays.toString(arr2));

        System.out.println("Java".replace("a", "o")); // Replace

        System.out.println("abc123".replaceAll("\\d", "")); // Replace all uses regex

        System.out.println("Java".replaceFirst("a", "o")); // Replace first uses regex

        System.out.println("java".toUpperCase()); // UPPERCASE

        System.out.println("JAVA".toLowerCase()); // lowercase

        System.out.println("  trim   this  ".trim()); // Trim white space before and after words

        System.out.println("*".repeat(3)); // Repeat String 3 times

        System.out.println("12345".matches("\\d+")); // Check matches (uses Regex)

        char[] chars = "Hello World".toCharArray(); // Convert String to char[]
        System.out.println(Arrays.toString(chars));

        byte[] bytes = "Hello World".getBytes(); // Convert String to byte[]
        System.out.println(Arrays.toString(bytes));

        System.out.println(String.join(",", "Java", "Spring", "Docker")); // Join elements to String with delimiter

        System.out.println(String.format("%s is %d years old", "Alice", 20)); // String format

        System.out.println(String.valueOf(100)); // Convert X to String

        // ============ Stream ==============
        "Java".chars().forEach(System.out::println); // Convert to int stream then print (ASCII)

        System.out.println(Arrays.stream("java is cool".split(" ")).count()); // Stream split String then count

        System.out.println(Arrays.stream("abc,def,".split(",")).filter(s -> !s.isBlank()).toList()); // Stream split String filter blank
    }

    public static void learnStringBuilder123() {
        // Init
        StringBuilder sb = new StringBuilder();
        sb.append("Java"); // append String to Builder
        sb.append("is");
        sb.append("awesome");

        // String Builder frequently use functions:
        // append()
        // insert()
        // delete()
        // deleteCharAt()
        // replace()
        // reverse()
        // length()
        // charAt()
        // setCharAt()
        // toString()

        System.out.println(sb);
    }
}
