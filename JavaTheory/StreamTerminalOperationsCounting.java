package JavaTheory;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StreamTerminalOperationsCounting {
    public static void main(String[] args) {
        // Counting all elements
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        Long count = names.stream().collect(Collectors.counting());
        System.out.println(count);

        // Counting with Filterting
        List<Integer> numbers = Arrays.asList(1, 5, 2, 8, 3, 6);
        long evenNumberCount = numbers.stream().filter(num -> num % 2 == 0).collect(Collectors.counting());
        System.out.println(evenNumberCount);

        // Counting null values
        List<String> values = Arrays.asList("hello", null, "world", null);
        long nullValuesCount = values.stream().filter(Objects::isNull).collect(Collectors.counting());
        System.out.println(nullValuesCount);

        // Counting Distinct Elements
        List<Integer> duplicates = Arrays.asList(2, 5, 2, 8, 8, 5);
        long distinctCount = duplicates.stream().distinct().collect(Collectors.counting());
        System.out.println(distinctCount);

        // Word count in a text
        String text = "The quick brown fox jumps over the lazy dog";
        long wordCount = Arrays.stream(text.split("\\s")).collect(Collectors.counting());
        System.out.println(wordCount);

        // Counting Files in a directory
        File directory = new File("C:\\Users\\lambo\\Downloads");
        long fileCount = Arrays.stream(directory.listFiles()).collect(Collectors.counting());
        System.out.println(fileCount);
    }
}
