package JavaTheory;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class StreamNumericStreams {
    public static void main(String[] args) {
        // IntStream range()
        System.out.println("Range :");
        IntStream intStream = IntStream.range(1,10);
        intStream.forEach(System.out::println);

        // IntStream rangeClosed()
        System.out.println("Range Closed :");
        intStream = IntStream.rangeClosed(1,10);
        intStream.forEach(System.out::println);

        // DoubleStream
        System.out.println("Double Stream : ");
        DoubleStream doubleStream = IntStream.range(1,10).asDoubleStream();
        doubleStream.forEach(System.out::println);

        // You're tasked with calculating the sum of squares of even numbers within a range. How would you implement this using numeric streams??
        System.out.println("Sum of even numbers : ");
        int sumOfEvenSquares = IntStream.rangeClosed(1,10).filter(num -> num%2==0).map(num -> num * 2).sum();
        System.out.println(sumOfEvenSquares);

        // Basic Sum Calcualtion
        int sum = IntStream.of(1,2,3,4,5).sum();
        System.out.println(sum);

        // Finding Maximum
        OptionalInt  max = IntStream.rangeClosed(1,10).max();
        System.out.println(max);

        // Finding minimum
        OptionalInt min = IntStream.rangeClosed(1,10).min();
        System.out.println(min);

        // Average Calculation
        OptionalDouble  average = DoubleStream.of(1,2,3,4,5).average();
        System.out.println(average);

        // Boxing with Numeric Streams
        List<Integer> boxedIntegerList = IntStream.rangeClosed(1,10).boxed().collect(Collectors.toList());
        System.out.println(boxedIntegerList);

        // Unboxing with Numeric Streams
        sum = boxedIntegerList.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        //
        
    }

}
