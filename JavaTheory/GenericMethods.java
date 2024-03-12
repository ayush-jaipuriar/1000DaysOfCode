package JavaTheory;
import java.util.ArrayList;
import java.util.List;

public class GenericMethods {

    public static void main(String[] args) {
        // Basic Generic Method 
        String name = getFirst(new ArrayList<>(List.of("Alice", "Bob"))); 
        System.out.println(name); 

        // Bounded Type Parameter
        System.out.println(max(10, 20));  

        // Overlapping Type Parameters (avoid if possible)
        Box<Integer> intBox = new Box<>();
        intBox.inspect(5); // Confusing - which 'T' is used? 

        // Wildcards for Flexibility
        List<? extends Number> numbers = new ArrayList<>(List.of(5, 5.5));
        copy(numbers, new ArrayList<Number>()); // Covariance in action

        // Tricky Inference - overly general 
        // process(new ArrayList<Integer>(), "hello"); // Infers T as Object

        // Generic Method in Non-generic Class
        List<String> sortedList = sort(new ArrayList<>(List.of("zebra", "apple")));
        System.out.println(sortedList);

        // Wildcard Capture (See comments in inspectAnimals)
        inspectAnimals(new ArrayList<>(List.of(new Dog())));
    } 

    // ---- Helper and Demo Methods ----

    // Simple generic method 
    public static <T> T getFirst(List<T> list) {
        return list.get(0);
    }

    // Generic method with bounded type parameter
    public static <T extends Comparable<T>> T max(T first, T second) {
        return (first.compareTo(second) > 0) ? first : second;
    }

    // Overriding type parameters - generally not recommended
    static class Box<T> {
        public <T> void inspect(T item) { 
            // ... 
        }
    }

    // Wildcards in action
    public static void copy(List<? extends Number> src, List<? super Number> dest) {
        for (Number number : src) {
            dest.add(number);
        }
    }

    // Tricky inference example
    public static <T> void process(List<T> list, T item) {
        // ... (Assume logic depending on T)
    }

    // Generic method within a non-generic class
    public static <T extends Comparable<T>> List<T> sort(List<T> list) {
        // ... (Implementation using Collections.sort() likely)
        return list;
    }

    // Example illustrating wildcard capture 
    public static void inspectAnimals(List<? extends Animal> animals) {
        // The compiler might infer a more specific captured type here
        // to ensure it's safe to add Animals to the list, if we tried
    }    

    // --- Example Classes (if needed) ---
    static class Animal {}
    static class Dog extends Animal {} 
}
