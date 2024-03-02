package JavaTheory;

abstract class Animal {
    // Abstract method (must be implemented by subclasses)
    public abstract void makeSound();

    // Concrete method (default implementation)
    public void sleep() {
        System.out.println("Zzz... Animal is sleeping.");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }
}

public class AbstractClassExample {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        myDog.makeSound(); // Calls the overridden method in Dog
        myDog.sleep();     // Calls the inherited concrete method
    }
}
