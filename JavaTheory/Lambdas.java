package JavaTheory;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Lambdas {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        List<Integer> evenNumbers = list.stream().filter(x-> x%2==0).collect(Collectors.toList());
        System.out.println(evenNumbers.toString());

        String message = "Hello";
        Runnable runnable = () -> System.out.println(message);

        int[] counter = {0};
        System.out.println("Counter : " + counter[0]);
        Runnable runnable2 = () -> System.out.println(counter[0]++);
        System.out.println("Counter after incrementing it within lambda: " + counter[0]);
        runnable.run();

        AtomicInteger atomicCounter = new AtomicInteger(1);
        System.out.println("Atomic Counter value before increment : " + atomicCounter.get());
        atomicCounter.getAndIncrement();
        System.out.println("Atomic Counter value after increment : " + atomicCounter.get());


    }
}
