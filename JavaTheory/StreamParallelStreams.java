package JavaTheory;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class StreamParallelStreams {
    public static void main(String[] args) {
        // Basic Parallel Summation
        long sum = IntStream.rangeClosed(1, 1000000).sum();
        System.out.println(sum);
        long parallelSum = LongStream.rangeClosed(1,1000000000).parallel().sum();
        System.out.println(sum);

        // Parallelizing filtering and mapping
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> parallelResult = numbers.stream().parallel().filter(n-> n%2==0).map(n -> n * n).collect(Collectors.toList());
        System.out.println(parallelResult);

        // Finding an element
        List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Emily");
        Optional<String> filteredString = names.stream().parallel().filter(str -> str.startsWith("D")).findAny();
        System.out.println(filteredString.get());
        
        // Reduction with custom accumulator
        long total = IntStream.rangeClosed(1, 10).reduce(1, (a, b) -> a * b);
        System.out.println(total);

        // Parallel Sorting
        int[] numbersArray = {5, 3, 8, 1, 9, 2};
        Arrays.parallelSort(numbersArray);
        System.out.println(Arrays.toString(numbersArray));

    }
}
