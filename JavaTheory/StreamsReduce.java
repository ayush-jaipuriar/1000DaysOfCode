package JavaTheory;

import java.util.Arrays;
import java.util.List;

public class StreamsReduce {
    public static void main(String[] args) {
        // sum of elements
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        int sum = numbers.stream().reduce(1, (a,b) -> a+b);
        System.out.println(sum);

        // product of elements
        int product = numbers.stream().reduce(1, (a,b) -> a*b);
        System.out.println(product);

        // finding max number
        int max = numbers.stream().reduce(Integer.MIN_VALUE, Integer::max);
        System.out.println(max);

        // concatenating string
        List<String> words = Arrays.asList("hello", " ", "world", "!");
        String concatenatedString = words.stream().reduce("", (a,b) -> a+b);
        System.out.println(concatenatedString);

        // Counting elements with a condition(positive numbers in this case)
        List<Integer> mixedNumbers = Arrays.asList(3, -6, 1, 5, -2);
        int positiveNumberSum = mixedNumbers.stream().filter(num -> num>0).reduce(0, (a,b) -> a+b);
        System.out.println(positiveNumberSum);
    }
}
