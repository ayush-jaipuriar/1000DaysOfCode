package JavaTheory;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamFind {
    public static void main(String[] args) {
        // Finding the first even number
        List<Integer> numbers = Arrays.asList(3, 8, 5, 12, 9);
        Optional<Integer> firstEvenNumber = numbers.stream().filter(num-> num%2==0).findFirst();
        System.out.println(firstEvenNumber.get());

        // Finding the first long string
        List<String> words = Arrays.asList("hello", "world", "programming");
        Optional<String> firstLongString = words.stream().filter(str -> str.length() > 5).findFirst();
        System.out.println(firstLongString.get());

        // Find any file with specific extension
        File directory = new File("C:\\Users\\lambo\\Downloads");
        Optional<File> pdfFile = Arrays.stream(directory.listFiles()).filter(file -> file.getName().endsWith("pdf")).findAny();
        System.out.println(pdfFile.get().getName());

    }

}
