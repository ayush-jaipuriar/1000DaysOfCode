package JavaTheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamTerminalMapping {
    public static void main(String[] args) {
        // Basic transformation and collection into a list
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<Integer> transformedNumbers = numbers.stream()
                .collect(Collectors.mapping(num -> num * 2, Collectors.toList()));
        System.out.println(transformedNumbers);

        // Collection Into a set
        List<String> names = Arrays.asList("Alice", "Bob", "Alice");
        Set<String> uniqueNames = names.stream().collect(Collectors.mapping(String::toLowerCase, Collectors.toSet()));
        System.out.println(uniqueNames);

        // Creating a map with Collectors.toMap()
        Map<String, Integer> stringLengthMap = uniqueNames.stream().collect(Collectors.toMap(s -> s, s -> s.length()));
        System.out.println(stringLengthMap);

        // Demonstrate the fact that after Java 10 all lists,sets etc collected by
        // calling Collectors.toList() etc are immutable
        // List<Integer> myList = Arrays.asList(1, 2, 3).stream().collect(Collectors.toList());
        // myList.add(5);
        // System.out.println(myList);

        List<Integer> myList = new ArrayList<>(Arrays.asList(1, 2, 3)); 
        List<Integer> newList = myList.stream().collect(Collectors.toList()); 
        myList.add(4); // Works (modifying the original mutable list)
        newList.add(5); // Will throw an exception
        System.out.println(newList);

    }

}
