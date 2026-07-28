import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LearnHashMap {
    public static void main(String[] args) {
        learnHashMap();
        learnConcurrentHashMap();
    }

    public static Map<String, Integer> resetMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 10);
        map.put("banana", 20);
        return map;
    }

    public static void learnHashMap() {
        // Init
        Map<String, Integer> map = new HashMap<>();

        map.put("apple", 10); // Add new key-value to map
        map.put("banana", 20);
        System.out.println(map);

        map.put("apple", 30); // Update value if key exists
        System.out.println(map);

        map.putIfAbsent("apple", 50); // Add new key-value only if key not exists

        System.out.println(map.get("apple")); // Get value by key

        System.out.println(map.getOrDefault("apple", 0)); // Get value by key, if not exists return default value

        System.out.println(map.containsKey("apple")); // Check contains key

        System.out.println(map.containsValue(30)); // Check contains value

        map.remove("banana"); // Remove key-value by key from map
        System.out.println(map);
        map.remove("apple", 30); // Remove key-value by key-value from map
        System.out.println(map);

        map = resetMap();

        map.replace("apple", 100); // Replace value by key
        map.replace("olive", 200); // If key not exists, nothing happens

        // Traverse map: entrySet
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        // Traverse only key
        for (String key : map.keySet()) {
            System.out.println(key);
        }

        // Traverse only value
        for (Integer value : map.values()) {
            System.out.println(value);
        }

        // Traverse map: for-each
        map.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });

        map.compute("apple", (k,v) -> v == null ? 1 : v + 1); // Compute value by key
        System.out.println(map);

        map.computeIfAbsent("apple", k -> 100); // Compute if key not exists
        System.out.println(map);
        map.computeIfAbsent("apple2", k -> 100); // Compute if key not exists
        System.out.println(map);

        map.computeIfPresent("apple", (k,v) -> v + 100); // Compute if key exists
        System.out.println(map);

        map.merge("apple", 1, Integer::sum); // If key exists, using lambda to process new value (value) with old value (current value in map)
        System.out.println(map);
        map.merge("apple3", 1, Integer::sum); // If key not exists, add new key-value (value is the same as we defined)
        System.out.println(map);

        System.out.println(map.size()); // Map size

        System.out.println(map.isEmpty()); // Check map is empty

        map.clear(); // Clear map
        System.out.println(map);
    }

    public static void learnConcurrentHashMap() {
        // Same as HashMap, only multi-thread
        Map<String, Integer> map = new ConcurrentHashMap<>();

        // The differences
        map.putIfAbsent("a", 1); // Multi-thread calls this function, only 1 thread put succeed (thread-safe)

        map.computeIfAbsent("b", k -> 1); // Multi-thread calls this function, only 1 thread compute succeed (thread-safe)
    }
}
