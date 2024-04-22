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
        // Sorting students by id
        Collections.sort(students, Comparator.comparing(Student::id));
        System.out.println(students.toString());

        // Sorting by multiple criteria(Comparator chaining)
        // sorting students by score then name
        Comparator<Student> byScoreThenByName = Comparator.comparing(Student::score).thenComparing(Student::name);
        Collections.sort(students, byScoreThenByName);
        Collections.sort(students, Comparator.comparing(Student::name).thenComparing(Student::score));
        System.out.println(students.toString());
        // Sorting Students by name then score
        Collections.sort(students, Comparator.comparing(Student::name).thenComparing(Student::score));
        System.out.println("Sorted by name then score : " + students.toString());

        // Descending Order
        Comparator<Student> byScoreDesc = Comparator.comparing(Student::score).reversed();
        Collections.sort(students, byScoreDesc);
        Collections.sort(students, Comparator.comparing(Student::name).reversed());
        System.out.println(students.toString());

        // Null Handling
        students.add(new Student(3,null, 0));
        Comparator<Student> byNameNullsFirst = Comparator.nullsFirst(Comparator.comparing(Student::name, Comparator.nullsFirst(Comparator.naturalOrder())));    
        Collections.sort(students, byNameNullsFirst);
        System.out.println(students.toString());
        // Putting nulls first then using natural order
        Collections.sort(students, Comparator.comparing(Student::name, Comparator.nullsFirst(Comparator.naturalOrder())));
        System.out.println("Sorted nullsFirst then student Name" + students.toString());

    }

}
