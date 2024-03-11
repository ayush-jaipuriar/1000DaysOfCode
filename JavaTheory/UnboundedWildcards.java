package JavaTheory;

import java.util.ArrayList;
import java.util.List;

public class UnboundedWildcards {

    public static void getCollectionSize(List<?> list) {
        System.out.println("List size : " + list.size());
    }

    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        // List of Strings
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");

        // List of Integers
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);

        // Demonstrating the flexibility of printList
        System.out.println("Printing list of Strings:");
        printList(names);

        System.out.println("Printing list of Integers:");
        printList(numbers);
    }

}
