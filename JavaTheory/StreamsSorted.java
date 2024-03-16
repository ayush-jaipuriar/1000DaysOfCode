package JavaTheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsSorted {

    record Student(int id, String name) {};

    public static void main(String[] args) {
        // Sorting Numbers
        List<Integer> list = Arrays.asList(1,3,2,6,4,11,2,4);
        System.out.println(list.toString());
        List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList);

        // Sorting Strings
        List<String> words = Arrays.asList("banana", "apple", "cherry", "date");
        System.out.println(words.toString());
        List<String> sortedWords = words.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedWords);

        // Sorting Custom objects by name
        List<Student> studentsList = new ArrayList<>();
        studentsList.add(new Student(1,"Ayush"));
        studentsList.add(new Student(2,"Ankur"));
        System.out.println(studentsList);
        List<Student> sortedStudentsList = studentsList.stream().sorted(Comparator.comparing(Student::name)).collect(Collectors.toList());
        System.out.println(sortedStudentsList);

    }
}
