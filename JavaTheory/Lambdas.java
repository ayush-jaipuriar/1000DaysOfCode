package JavaTheory;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lambdas {
    public static void main(String[] args) {
        // Creating a list of integers
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // Using a lambda expression to filter even numbers from the list
        List<Integer> evenNumbers = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println(evenNumbers.toString());

        // Defining a message and using a lambda expression to print it
        String message = "Hello";
        Runnable runnable = () -> System.out.println(message);

        // Using an array to demonstrate variable capture in lambda expressions
        int[] counter = { 0 };
        System.out.println("Counter : " + counter[0]);

        // Demonstrating the use of lambda expressions with side effects
        Runnable runnable2 = () -> System.out.println(counter[0]++);
        System.out.println("Counter after incrementing it within lambda: " + counter[0]);

        // Running the lambda expression to print the message
        runnable.run();

        // Using AtomicInteger for thread-safe operations
        AtomicInteger atomicCounter = new AtomicInteger(1);
        System.out.println("Atomic Counter value before increment : " + atomicCounter.get());
        atomicCounter.getAndIncrement();
        System.out.println("Atomic Counter value after increment : " + atomicCounter.get());

        // Using a lambda expression as a Consumer
        Consumer<String> logMessage = (msg) -> System.out.println("LOG Message : " + msg);
        logMessage.accept("Hello World");

        // Using a lambda expression as a Predicate
        Predicate<Integer> evenCheckPredicate = number -> number % 2 == 0;
        List<Integer> numbersList = Arrays.asList(1, 2, 3, 4, 5);

        // Filtering even numbers using the Predicate
        List<Integer> evenNumberList = numbersList.stream().filter(evenCheckPredicate).collect(Collectors.toList());
        numbersList.stream().filter(evenCheckPredicate).forEach(System.out::println);
        System.out.println(evenNumberList.toString());
    }
}