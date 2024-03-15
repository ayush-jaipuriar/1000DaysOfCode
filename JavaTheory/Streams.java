package JavaTheory;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        // Intermediate and Termnial operations in Streams
        // filter() , map() etc are intermediate operations
        // count() is terminal operation
        long count = list.stream().filter(n -> n % 2 == 0).count();
        System.out.println(count);

        //
        List<Integer> squares = list.stream().map(num -> num * num).collect(Collectors.toList());
        System.out.println(squares.toString());

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Optional<Integer> firstEven = numbers.stream()
                .filter(n -> n % 2 == 0) // Intermediate (lazy)
                .map(n -> n * 2) // Intermediate (lazy)
                .findFirst(); // Terminal - triggers computation
        System.out.println(firstEven.get());
    }
}
