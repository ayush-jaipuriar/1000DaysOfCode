// Package declaration
package JavaTheory;

// Interface declaration
interface Animal {
    // Abstract method declaration
    void sound();
}

// Class Dog implementing the Animal interface
class Dog implements Animal {
    // Implementation of the abstract method sound
    public void sound() {
        // Using System.out.println for demonstration purposes
        System.out.println("Woof Woof!");
    }
}

// Parent class declaration
class Parent {
    // Method display in the Parent class
    void display() {
        // Using System.out.println for demonstration purposes
        System.out.println("Parent class method");
    }
}

// Child class extending the Parent class
class Child extends Parent {
    // Overriding the display method from the Parent class
    void display() {
        // Using System.out.println for demonstration purposes
        System.out.println("Child class method");
    }
}

// Main class MethodBinding
public class MethodBinding {
    public static void main(String[] args) {
        // Creating an instance of Parent class
        Parent obj1 = new Parent();
        // Creating an instance of Child class and assigning it to a Parent type reference
        Parent obj2 = new Child();
        
        // Early binding - The method to be called is determined at compile time
        obj1.display(); // Outputs: Parent class method
        // Late binding - The method to be called is determined at runtime
        obj2.display(); // Outputs: Child class method
        
        // Method Binding Example for abstract methods which get resolved at compile time 
        // based on the implementation provided by the implementing method
        Animal dog = new Dog();
        // Calling the sound method of the Dog class
        dog.sound(); // Outputs: Woof Woof!
    }
}