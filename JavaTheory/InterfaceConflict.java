package JavaTheory;

// Define interface A
interface A {
    default void foo() {
        System.out.println("Inside interface A");
    }
}

// Define interface B
interface B {
    default void foo() {
        System.out.println("Inside interface B");
    }
}

// Class C implements both interfaces A and B
class C implements A, B {
    @Override
    public void foo() {
        System.out.println("Inside implementation C");
    }
}

public class InterfaceConflict {
    public static void main(String[] args) {
        // Create an instance of class C
        C c = new C();
        // Call the overridden foo() method
        c.foo(); // Output: Inside implementation C
    }
}
