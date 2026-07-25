//Arrays (the bedrock)
//Primitive arrays
//- int[], char[], long[], double[]
//- Multidimensional: int[][], char[][]
//When they appear
//- Two pointers
//- Sliding window
//- Prefix sums
//- Binary search
//- DP tables
//- Matrix traversal
//- Key tricks
//- Index math > elegance
//- Pre-allocating for O(1) access
//- In-place mutation to save space
//Arrays are fast, dumb, and brutally effective.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LearnArray {
    public static void main(String[] args) {
        arrayExample();
        arrayListExample();
        convertArrayToArrayList();
        convertArrayListToArray();
    }

    public static int[] resetArray() {
        return new int[]{5,2,8,1};
    }

    public static void arrayExample() {
        // Init array
        int[] arr1 = new int[5]; // Init int array with size = 5, default value = 0
        int[] arr2 = {1, 2, 3, 4, 5}; // Init int array with custom value
        String[] names = {"Alice", "Bob"};

        // Array methods
        int[] arr = {5,2,8,1};
        System.out.println("Original array: " + Arrays.toString(arr));

        Arrays.sort(arr); // in-place sort
        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.binarySearch(arr, 5)); // Binary search array (array must be sorted before)

        Arrays.fill(arr, 100); // Fill all value in array with value 100
        System.out.println(Arrays.toString(arr));

        arr = resetArray();

        int[] copy = Arrays.copyOf(arr, arr.length); // Copy array to new array
        System.out.println(Arrays.toString(copy));
        int[] bigger = Arrays.copyOf(arr, arr.length + 10); // Copy array to new array with bigger size
        System.out.println(Arrays.toString(bigger));
        int[] smaller = Arrays.copyOf(arr, arr.length - 1); // Copy array to new array with smaller size
        System.out.println(Arrays.toString(smaller));

        int[] sub = Arrays.copyOfRange(arr, 1, 4); // Copy a range of original array
        System.out.println(Arrays.toString(sub));

        int[] arr3 = {1,2,3};
        int[] arr4 = {1,2,3};
        int[] arr5 = {3,2,1};
        System.out.println(Arrays.equals(arr3, arr4)); // Compare values of 2 arrays
        System.out.println(Arrays.equals(arr3, arr5)); // Compare values of 2 arrays

        int[][] matrix1 = {{1,2}, {3,4}};
        int[][] matrix2 = {{1,2}, {3,4}};
        int[][] matrix3 = {{1,2}, {3,5}};
        System.out.println(Arrays.deepEquals(matrix1, matrix2)); // Compare value of 2 array of arrays (more than 1 layer)
        System.out.println(Arrays.deepEquals(matrix1, matrix3)); // Compare value of 2 array of arrays (more than 1 layer)

        System.out.println(Arrays.deepToString(matrix1)); // Convert arrays of array to printable String
        System.out.println(Arrays.toString(arr)); // Convert array to printable String
        System.out.println(Arrays.deepToString(new int[][][] {{{1}}, {{2}}}));

        Arrays.stream(arr).forEach(System.out::println); // Stream API (print array this case)

        Arrays.parallelSort(arr); // Sort using multiple threads
        System.out.println(Arrays.toString(arr));

        arr = resetArray();

        Arrays.setAll(arr, i -> i * 2); // Fill/populate values to array (value = index * 2)
        System.out.println(Arrays.toString(arr));

        Arrays.parallelSetAll(arr, i -> i * 10); // Fill/populate values to array (value = index * 2) using multiple threads
        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.compare(arr3, arr4)); // Equal arrays return 0
        System.out.println(Arrays.compare(arr3, arr5)); // Not equal arrays return -1

        System.out.println(Arrays.mismatch(arr3, arr4)); // Equal arrays return -1
        System.out.println(Arrays.mismatch(arr3, arr5)); // Not equal arrays return first index of mismatch value
    }

    public static List<Integer> resetArrayList() {
        List<Integer> list = new ArrayList<>();

        list.add(1); // Add value to array list
        list.add(2); // Add value to array list
        list.add(1, 3);

        return list;
    }

    public static void arrayListExample() {
        // Init array list
        List<Integer> list = new ArrayList<>();

        list.add(1); // Add value to array list
        list.add(2); // Add value to array list
        list.add(1, 3); // Add value at specific index to array list
        System.out.println(list);

        System.out.println(list.get(1)); // Get value from index

        list.set(1, 10); // Set value of index
        System.out.println(list);

        list.remove(1); // Remove value by index
        System.out.println(list);

        List<String> list2 = new ArrayList<>();
        list2.add("Python");
        list2.add("Java");
        list2.remove("Python");
        System.out.println(list2);

        list.clear(); // Clear all data

        list = resetArrayList();

        System.out.println(list.size()); // Get list size

        System.out.println(list.contains(1)); // Check if array list contain 1

        System.out.println(list.indexOf(1)); // Index of value 1

        System.out.println(list.lastIndexOf(1)); // Last index of value 1

        System.out.println(list.isEmpty()); // Check if array list is empty (size = 0)

        list.sort(Integer::compareTo); // Sort array list (with Comparator)
        System.out.println(list);

        list.removeIf(i -> i % 2 == 0); // Remove with if condition
        System.out.println(list);

        list.forEach(System.out::println); // For each an array list

        System.out.println(Arrays.toString(list.toArray())); // Convert array list to array
        System.out.println(Arrays.toString(list2.toArray(new String[0]))); // Convert array list String to array (Type 1)
        System.out.println(Arrays.toString(list2.toArray(String[]::new))); // Convert array list String to array (Type 2)

        System.out.println(list.subList(1,2)); // Sub array list from original array list

        // Collections with array list
        Collections.sort(list); // In-place sort

        Collections.reverse(list); // In-place sort reverse

        Collections.shuffle(list); // In-place shuffle

        Collections.swap(list, 0, 1); // In-place swap position of index i and j
        System.out.println(list);

        System.out.println(Collections.max(list)); // Get max of array list

        System.out.println(Collections.min(list)); // Get min of array list

        System.out.println(Collections.frequency(list, 1));

        Collections.fill(list2, "abc");
        System.out.println(list2);

        list = resetArrayList();

        List<Integer> temp = new ArrayList<>(list);
        Collections.copy(list, temp);
        System.out.println(temp);

        Collections.sort(temp);
        System.out.println(Collections.binarySearch(temp, 1));

        Collections.rotate(list, 1);
        System.out.println(list);

        System.out.println(Collections.singletonList(1));

        System.out.println(Collections.unmodifiableList(list));
    }

    public static void convertArrayToArrayList() {
        // Immutable
        String[] arr = {"A", "B", "C"};
        List<String> list = Arrays.asList(arr);
        System.out.println(list);

        List<String> list2 = new ArrayList<>(Arrays.asList(arr));
        System.out.println(list2);

        List<String> list3 = new ArrayList<>();
        Collections.addAll(list3, arr);
        System.out.println(list3);

        // Immutable
        List<String> list4 = Arrays.stream(arr).toList();
        System.out.println(list4);

        List<String> list5 = Arrays.stream(arr).collect(Collectors.toList());
        System.out.println(list5);

        List<String> list6 = Arrays.stream(arr).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(list6);

        // Immutable
        List<String> list7 = List.of(arr);
        System.out.println(list7);
    }

    public static void convertArrayListToArray() {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");

        String[] arr = list.toArray(new String[0]);
        System.out.println(Arrays.toString(arr));

        String[] arr2 = list.toArray(String[]::new);
        System.out.println(Arrays.toString(arr2));

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        int[] arr3 = list2.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(arr3));
    }
}
