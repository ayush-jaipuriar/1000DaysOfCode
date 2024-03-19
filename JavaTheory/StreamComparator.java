package JavaTheory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StreamComparator {
    record Student(int id, String name, int score) {}        

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Ayush",9));
        students.add(new Student(2,"Ankur",10));

        // Basic Sorting by a single property
        Collections.sort(students, Comparator.comparing(Student::id));
        System.out.println(students.toString());

        // Sorting by multiple criteria(Comparator chaining)
        Comparator<Student> byScoreThenByName = Comparator.comparing(Student::score).thenComparing(Student::name);
        Collections.sort(students, byScoreThenByName);
        System.out.println(students.toString());

        // Descending Order
        Comparator<Student> byScoreDesc = Comparator.comparing(Student::score).reversed();
        Collections.sort(students, byScoreDesc);
        System.out.println(students.toString());

        // Null Handling
        students.add(new Student(3,null, 0));
        Comparator<Student> byNameNullsFirst = Comparator.nullsFirst(Comparator.comparing(Student::name, Comparator.nullsFirst(Comparator.naturalOrder())));
        Collections.sort(students, byNameNullsFirst);
        System.out.println(students.toString());
        

    }

}
