package JavaTheory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamFactoryMethods {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Using of() directly
        Stream<String> nameStream= Stream.of("Ayush", "Ankur");
        nameStream.forEach(System.out::println);

        // Using of() to create a stream from a list
        Stream<List<String>> listStream = Stream.of(names);
        listStream.forEach(System.out::println);

        // iterate() - Infinite stream with repeated function application
        Stream<Integer> powerOfTwoStream = Stream.iterate(1, n -> n*2);
        powerOfTwoStream.limit(10).forEach(System.out::println);

        // generate() - Infinite Stream with supplier
        Stream<Double> infiniteStream = Stream.generate(Math::random);
        System.out.println("Starting the infinite stream using generate()");
        infiniteStream.limit(10).forEach(System.out::println);


    }

}
