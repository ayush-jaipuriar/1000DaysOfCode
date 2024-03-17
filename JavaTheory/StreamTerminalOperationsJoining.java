package JavaTheory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class StreamTerminalOperationsJoining {
    public static void main(String[] args) {
        // joining() Cases
        // Case 1: Basic Joining
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        String joinedNames = names.stream().collect(Collectors.joining());
        System.out.println(joinedNames);

        // Case 2: Joining with delimeter
        joinedNames = names.stream().collect(Collectors.joining(","));
        System.out.println(joinedNames);

        // Case 3: Joining with prefix and suffix
        String joinedWithBrackets = names.stream().collect(Collectors.joining(",", "[", "]"));
        System.out.println(joinedWithBrackets);

        // Case 4: Real World - Composing a CSV file
        List<Integer> numbers = Arrays.asList(1, 5, 3, 8);
        String csvLine = numbers.stream().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(csvLine);

        // Case 5: Joining elements from a map
        Map<String, Integer> ages = new HashMap<>();
        ages.put("Alice", 25);
        ages.put("Bob", 30);
        String joinedAges = ages.entrySet().stream().map(age -> age.getKey() + ":" + age.getValue())
                .collect(Collectors.joining(","));
        System.out.println(joinedAges);

        // Case 6: Avoiding NullPointerExceptions (Handling potential Nulls)
        List<String> maybeNulls = Arrays.asList("Hello", null, "World");
        String joinedSafe = maybeNulls.stream().filter(Objects::nonNull).collect(Collectors.joining(","));
        System.out.println(joinedSafe);

        // Case 7: Joining with different String representations
        numbers = Arrays.asList(1, 5, 3, 8);
        String joinedWithHyphens = numbers.stream().map(String::valueOf).collect(Collectors.joining("-"));
        System.out.println(joinedWithHyphens);

    }
}
