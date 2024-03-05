package JavaTheory;

// The MyInterface interface demonstrates the use of static methods in interfaces.
// Static methods in interfaces were introduced in Java 8 to allow utility methods to be defined in interfaces.
// This is particularly useful for default methods that need to be shared across multiple implementations.
interface MyInterface {
    int nonStaticField = 0;
    // This is a static method defined in the interface.
    // Static methods belong to the interface itself and can be called without creating an instance of the interface.
    // They can be used to perform operations that are common to all implementations of the interface.
    static void staticMethodInInterface() {
        // This method prints a message to the console.
        // It demonstrates how static methods can be used for utility purposes.
        System.out.println("Static Method invoked in Interface");
    }

    default void defaultMethod() {
        System.out.println("Inside default method in MyInterface");
    }
}

// The InterfaceStaticMethods class implements the MyInterface interface.
// By implementing the interface, it inherits the static method defined in the interface.
class InterfaceStaticMethods implements MyInterface {

    // public void defaultMethod() {
    //     System.out.println("Inside defaultMethod in InterfaceStaticMethods class");
    // }

    public static void main(String[] args) {
        // Creating an instance of InterfaceStaticMethods is not necessary to call the static method.
        InterfaceStaticMethods interfaceStaticMethods = new InterfaceStaticMethods();
        
        // Calling the static method directly on the interface.
        // This is possible because static methods belong to the interface, not to any instance of the interface.
        MyInterface.staticMethodInInterface();
        
        // The commented-out line below would cause a compile error because static methods cannot be called on instances of the interface.
        // interfaceStaticMethods.staticMethodInInterface();
        interfaceStaticMethods.defaultMethod();
        


    }
}