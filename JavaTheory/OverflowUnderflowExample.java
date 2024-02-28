package JavaTheory;

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

public class OverflowUnderflowExample {
    public static void main(String[] args) {
        int maxValue = Integer.MAX_VALUE; // 2147483647
        int minValue = Integer.MIN_VALUE; // -2147483648

        // Overflow: Adding 1 to the maximum value
        int overflowResult = maxValue + 1;
        System.out.println("Overflow result: " + overflowResult); // -2147483648

        // Underflow: Subtracting 1 from the minimum value
        int underflowResult = minValue - 1;
        System.out.println("Underflow result: " + underflowResult); // 2147483647

        Student s1 = new Student("John");
        Student s2 = new Student("Raj");
        Student s3 = s2;
        s2 = new Student("Anita");
        s2 = s1;
        System.out.println(s3.name);

    }
}