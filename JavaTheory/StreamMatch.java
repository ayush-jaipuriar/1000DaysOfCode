package JavaTheory;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMatch {
    public static void main(String[] args) {
        // anyMatch() - Checking for odd numbers
        List<Integer> numbers = Arrays.asList(2, 4, 6, 7, 8);
        boolean anyOdd = numbers.stream().anyMatch(num -> num % 2 == 0);
        System.out.println(anyOdd);

        // allMatch - All Strings above a length
        List<String> words = Arrays.asList("computer", "science", "technology");
        boolean allLongWords = words.stream().allMatch(word -> word.length() > 5);
        System.out.println(allLongWords);

        // noneMatch() - none negative numbers
        numbers = Arrays.asList(3, 5, 8, 10);
        boolean noneNegative = numbers.stream().noneMatch(num -> num < 0);
        System.out.println(noneNegative);

        // anyMatch() - Finding specific file type
        File directory = new File("C:\\Users\\lambo\\Downloads");
        File[] files = directory.listFiles();

        boolean containsPdf = Arrays.stream(files).peek(file -> System.out.println("File Name : " + file.getName()))
                .anyMatch(file -> file.getName().endsWith("rar"));
        System.out.println("Directory contains PDF file? : " + containsPdf);

    }
}
