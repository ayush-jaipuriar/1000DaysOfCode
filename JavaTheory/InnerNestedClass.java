package JavaTheory;

// OuterClass is a non-static class that contains an instance variable 'data'
class OuterClass {
    int data = 10; // Instance variable of OuterClass

    // InnerClass is a non-static nested class within OuterClass
    class InnerClass {
        // Method to access the 'data' variable of the OuterClass
        void accessOuterData() {
            // Accessing the 'data' variable of the OuterClass using 'OuterClassName.this.variableName' syntax
            System.out.println("Entered accessOuterData method, data = " + OuterClass.this.data);
        }
    }

    // Main method to demonstrate the usage of InnerClass
    public static void main(String[] args) {
        // Creating an instance of OuterClass
        OuterClass outerClass = new OuterClass();
        // Creating an instance of InnerClass using the instance of OuterClass
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        // Calling the method of InnerClass to access the 'data' variable of OuterClass
        innerClass.accessOuterData();
    }
}