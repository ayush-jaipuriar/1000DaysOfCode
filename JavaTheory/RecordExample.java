package JavaTheory;

// Define a class named RecordExample
class RecordExample {
    public static void main(String[] args) {
        // Define a record named Student with two fields: name and studentId
        record Student(String name, String studentId) {
            // No additional methods or fields are defined within the record
        }

        // Create an instance of Student with name "Ayush" and studentId "123"
        Student student = new Student("Ayush", "123");
        
        // Print the name of the student
        System.out.println(student.name());
        
        // Print the studentId of the student
        System.out.println(student.studentId());
    }
}