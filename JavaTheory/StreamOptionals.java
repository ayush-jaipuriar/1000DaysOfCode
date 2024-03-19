package JavaTheory;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamOptionals {

    public static Optional<Integer> calculateLength(String text) {
        return Optional.ofNullable(text).map(String::length);
    }

    public static void main(String[] args) {
        // Method Chaining
        Optional<Integer> number = calculateLength(null);
        System.out.println(number.isPresent() ? number.get() : "");
        number = calculateLength("text");
        System.out.println(number.isPresent() ? number.get() : "");

        // Optional in Streams
        List<String> potentialNames = Arrays.asList("John", null, "Alice");
        potentialNames.stream().map(Optional::ofNullable).filter(Optional::isPresent).forEach(System.out::println);

        // orElse(), orElseGet() and orElseThrow() concepts
        // Simple default value with orElse()
        Optional<String> emptyOptional = Optional.empty();
        String name = emptyOptional.orElse("Hello World");
        System.out.println(name);

        // Computationally expensive default with orElseGet()
        // Optional<Discount> discount = Optional.empty();
        // Discount appliedDiscount = discount.orElseGet(() ->
        // calculateExpensiveDiscount());
        try {
            name = emptyOptional.orElseThrow(() -> new Exception("Empty Optional detected"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
