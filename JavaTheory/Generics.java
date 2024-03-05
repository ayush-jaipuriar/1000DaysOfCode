package JavaTheory;

/**
 * InnerGenerics
 * This example demonstrates the use of Java Generics, which allow types (classes and interfaces)
 * to be parameters when defining classes, interfaces, and methods.
 */
interface Container<T> {
    // The method set takes a parameter of type T, which is a generic type.
    void set(T a);

    // The method get returns a value of type T, which is a generic type.
    T get();
}

// The class Store implements the Container interface, making it a generic container.
// The type parameter T is used to specify the type of the object that this container will hold.
class Store<T> implements Container<T> {
    private T a; // The private field a is of type T, making it generic.

    @Override
    public void set(T a) {
        // This method sets the value of the private field a to the value passed as a parameter.
        // The type of a is determined by the type parameter T.
        this.a = a;
    }

    @Override
    public T get() {
        // This method returns the value of the private field a.
        // The return type is T, making the method generic.
        return a;
    }
}

public class Generics {

    public static void main(String[] args) {
        // Creating a Container of type String. The type parameter T is replaced with String.
        Container<String> stringContainer = new Store<>();
        stringContainer.set("Ayush");
        // System.out.println is used here for simplicity, but it's recommended to use a logger for production code.
        System.out.println("Container value : " + stringContainer.get());

        // Creating a Container of type Integer. The type parameter T is replaced with Integer.
        Container<Integer> integerContainer = new Store<>();
        integerContainer.set(1);
        // System.out.println is used here for simplicity, but it's recommended to use a logger for production code.
        System.out.println("Container value : " + integerContainer.get());
    }
}