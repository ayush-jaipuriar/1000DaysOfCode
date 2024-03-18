package JavaTheory;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
        List<String> words = Arrays.asList("hello", "world", "this", "is", "a", "stream");
        Map<Integer, List<String>> wordLengthMap = words.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(words);

        // Counting Occurrences
        List<Integer> numbers = Arrays.asList(2, 3, 5, 2, 3, 7, 3);
        Map<Integer, Long> numCount = numbers.stream()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()));
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
        Map<String, Double> totalPriceByCategory = items.stream().collect(Collectors.groupingBy(Item::getCategory,Collectors.summingDouble(Item::getPrice)));
        System.out.println(totalPriceByCategory);

    }

}
