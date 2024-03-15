package JavaTheory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapVsFlatMap {

    // Student class
    static class Student {
        String name;
        List<String> courses;

        Student(String name, List<String> courses) {
            this.name = name;
            this.courses = courses;
        }

        public String getName() {
            return name;
        }

        public List<String> getCourses() {
            return courses;
        }
    }

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        // Add some student data (name and courses)
        students.add(new Student("Alice", List.of("Math", "Physics")));
        students.add(new Student("Bob", List.of("English", "History", "Math")));
        students.add(new Student("Charlie", List.of("Physics", "Chemistry")));

        // 1. Get List of Student Names (using map)
        List<String> studentNames = students.stream()
                .map(Student::getName)
                .collect(Collectors.toList());

        System.out.println("Student Names: " + studentNames);

        // 2. Get List of All Courses (using flatMap)
        List<String> allCourses = students.stream().flatMap(student -> student.getCourses().stream()).distinct()
                .collect(Collectors.toList());

        System.out.println("All Courses (Flattened): " + allCourses);
    }

    
}
