import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LearnDataType {
    public static void main(String[] args) {
        convertStringInteger();
        convertDataType();
    }

    public static void convertStringInteger() {
        // ======= Convert String -> Integer ======= //
        String[] arr = {"1", "2", "3"};

        List<Integer> list = Arrays.stream(arr).map(Integer::parseInt).toList();
        System.out.println(list);

        List<Integer> list2 = new ArrayList<>();
        for (String s: arr) {
            list2.add(Integer.parseInt(s));
        }
        System.out.println(list2);

        List<String> list3 = new ArrayList<>();
        list3.add("1");
        list3.add("2");
        List<Integer> list4 = list3.stream().map(Integer::parseInt).toList();
        System.out.println(list4);

        // ======= Convert Integer -> String ======= //
        int[] arr2 = {1,2,3};
        List<String> list5 = Arrays.stream(arr2).mapToObj(String::valueOf).toList();
        System.out.println(list5);

        List<Integer> list6 = new ArrayList<>();
        list6.add(1);
        list6.add(2);
        List<String> list7 = list6.stream().map(String::valueOf).toList();
        System.out.println(list7);
    }

    public static void convertDataType() {
        String strNum = "123";
        String str = "Hello";
        String strBool = "True";
        int i = 1234;
        long l = 12345L;
        double d = 123.45;

        System.out.println(Long.parseLong(strNum)); // String -> Long

        System.out.println(Double.parseDouble(strNum)); // String -> Double

        System.out.println(Float.parseFloat(strNum)); // String -> Float

        System.out.println(Boolean.parseBoolean(strBool)); // String -> Boolean

        System.out.println(str.charAt(0)); // String -> Character

        System.out.println(Long.valueOf(i)); // Integer -> Long

        System.out.println(Double.valueOf(i)); // Integer -> Double

        System.out.println((int) l); // Long -> Integer
        System.out.println(Math.toIntExact(l)); // Long -> Integer

        System.out.println((int) d); // Double -> Integer
    }
}
