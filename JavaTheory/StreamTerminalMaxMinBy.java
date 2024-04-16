package JavaTheory;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamTerminalMaxMinBy {

    record Student(String name, int age, Double gpa) {
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Emily", 23, 3.8),
                new Student("James", 21, 3.2),
                new Student("Sarah", 24, 3.6));

        // Finding min by GPA
        Optional<Student> minGpaStudent = students.stream().collect(Collectors.minBy(Comparator.comparing(Student::gpa)));
        System.out.println(minGpaStudent.get());

        // Finding max by GPA
        Optional<Student> maxGpaStudent = students.stream().collect(Collectors.maxBy(Comparator.comparing(Student::gpa)));
        System.out.println(maxGpaStudent.get());

        // Finding min by Age
        Optional<Student> youngestStudent = students.stream().collect(Collectors.minBy(Comparator.comparing(Student::age)));
        System.out.println(youngestStudent.get());

        // Finding max by Age
        Optional<Student> oldestStudent = students.stream().collect(Collectors.maxBy(Comparator.comparing(Student::age)));
        System.out.println(oldestStudent.get());

        // Finding Min by String property (name)
        Optional<Student> studentAlphabeticalMin = students.stream().collect(Collectors.minBy(Comparator.comparing(Student::name)));
        System.out.println(studentAlphabeticalMin);

        // Finding max by String property (name)
        Optional<Student> studentAlphabeticalMax = students.stream().collect(Collectors.maxBy(Comparator.comparing(Student::name)));
        System.out.println(studentAlphabeticalMax);

        // Custom Comparator (By GPA then Name)
        Comparator<Student> gptThenNameComparator = Comparator.comparing(Student::gpa).thenComparing(Student::name);
        Optional<Student> minByGpaThenName = students.stream().collect(Collectors.minBy(gptThenNameComparator));
        System.out.println(minByGpaThenName.get());

        // Custom Comparator (By GPA then name)
        Optional<Student> maxByGpaThenName = students.stream().collect(Collectors.maxBy(gptThenNameComparator));
        System.out.println(maxByGpaThenName.get());

        // Numeric Data Types
        List<Integer> numbers = Arrays.asList(5, 1, 8, 3, 9);
        // Find Min Num in numbers list
        Optional<Integer> minNum = numbers.stream().collect(Collectors.minBy(Integer::compareTo));
        System.out.println(minNum.get());

        // Find max number in numbers list
        Optional<Integer> maxNum = numbers.stream().collect(Collectors.maxBy(Integer::compareTo));
        System.out.println(maxNum.get());

        // Null Handling (with nullsFirst and nullsLast)
        students = Arrays.asList(
                new Student("Emily", 23, 3.8),
                null, // A student with a null age
                new Student("Sarah", 24, 3.6));

        Comparator<Student> byAgeNullsFirst = Comparator.nullsFirst(Comparator.comparing(Student::age));
        Comparator<Student> byAgeNullsLast = Comparator.nullsLast(Comparator.comparing(Student::age));

        Optional<Student> youngestWithNullsFirst = students.stream().collect(Collectors.minBy(byAgeNullsFirst));
        System.err.println(youngestStudent.get());

    }

}
