package JavaTheory;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

class Student {
    private String name;
    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    // Getters ...
    public String getName() {
        return name;
    }

    public double getGPA() {
        return gpa;
    }
}

class Employee {
    private String department;
    private String city;
    // ... other properties

    public Employee(String department, String city) {
        this.department = department;
        this.city = city;
    }

    // Getters ...
    public String getDepartment() {
        return department;
    }

    public String getCity() {
        return city;
    }
}

class Item {
    private String category;
    private double price;

    public Item(String category, double price) {
        this.category = category;
        this.price = price;
    }

    // Getters ...
    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}

public class StreamGrouping {
    public static void main(String[] args) {
        // Basic Grouping
        // Group by word length, each group should have a word length as group key and all words having the same length as its grouped values
        List<String> words = Arrays.asList("hello", "world", "this", "is", "a", "stream");
        Map<Integer, List<String>> wordLengthMap = words.stream().collect(Collectors.groupingBy(String::length));
        wordLengthMap = words.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(wordLengthMap.toString());

        // Counting Occurrences
        List<Integer> numbers = Arrays.asList(2, 3, 5, 2, 3, 7, 3);
        Map<Integer, Long> numCount = numbers.stream().collect(Collectors.groupingBy(num -> num, Collectors.counting()));
        numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(numCount);

        List<Employee> employees = Arrays.asList(
                new Employee("Sales", "New York"),
                new Employee("Marketing", "Chicago"),
                new Employee("Sales", "Los Angeles"),
                new Employee("HR", "New York"),
                new Employee("Marketing", "Seattle"));

        Map<String, Map<String, List<Employee>>> employeesByDeptAndCity = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.groupingBy(Employee::getCity)));
        System.out.println(employeesByDeptAndCity);

        List<Student> students = Arrays.asList(
                new Student("Alice", 3.6),
                new Student("Bob", 3.2),
                new Student("Charlie", 3.8),
                new Student("David", 3.3));

        Map<String, Set<Student>> studentsByGpaRange = students.stream().collect(Collectors
                .groupingBy(student -> student.getGPA() > 3.5 ? "Above average" : "Average", Collectors.toSet()));
        System.out.println(studentsByGpaRange);

        // Summing Values
        List<Item> items = Arrays.asList(
                new Item("Electronics", 50.0),
                new Item("Books", 15.0),
                new Item("Electronics", 80.0),
                new Item("Books", 20.0));
        Map<String, Double> totalPriceByCategory = items.stream()
                .collect(Collectors.groupingBy(Item::getCategory, Collectors.summingDouble(Item::getPrice)));
        System.out.println(totalPriceByCategory);

        // Grouping with downstream collector to List
        Map<String, List<Employee>> employeesByCity = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity));
        System.out.println(employeesByCity);

        // Grouping with downstream collector to Set
        Map<String, Set<Employee>> uniqueEmployeesByCity = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity, Collectors.toSet()));
        System.out.println(uniqueEmployeesByCity);

        // Grouping and mapping to a different type
        Map<String, List<String>> employeeNamesByCity = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity,
                        Collectors.mapping(Employee::getDepartment, Collectors.toList())));
        System.out.println(employeeNamesByCity);

        // Grouping and summing an integer property
        Map<String, Integer> totalGpaByCategory = students.stream()
                .collect(Collectors.groupingBy(Student::getName,
                        Collectors.summingInt(student -> (int) student.getGPA())));
        System.out.println(totalGpaByCategory);

        // Grouping and averaging a double property
        Map<String, Double> averageGpaByCategory = students.stream()
                .collect(Collectors.groupingBy(Student::getName,
                        Collectors.averagingDouble(Student::getGPA)));
        System.out.println(averageGpaByCategory);

        // Grouping by multiple fields using a composite key
        Map<String, List<Employee>> employeesByDeptCity = employees.stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartment() + "|" + employee.getCity()));
        System.out.println(employeesByDeptCity);

        // Grouping by classification function and custom downstream collector
        Map<String, String> namesByGpaRange = students.stream()
                .collect(Collectors.groupingBy(student -> student.getGPA() > 3.5 ? "Above average" : "Average",
                        Collectors.mapping(Student::getName, Collectors.joining(", "))));
        System.out.println(namesByGpaRange);

        // Grouping by with reducing downstream collector
        Map<String, Optional<Student>> topGpaStudentByCategory = students.stream()
                .collect(Collectors.groupingBy(Student::getName,
                        Collectors.reducing((s1, s2) -> s1.getGPA() > s2.getGPA() ? s1 : s2)));
        System.out.println(topGpaStudentByCategory);

        // Grouping by with partitioningBy downstream collector
        Map<Boolean, List<Student>> partitionedStudents = students.stream()
                .collect(Collectors.partitioningBy(student -> student.getGPA() >= 3.5));
        System.out.println(partitionedStudents);

    }

}
