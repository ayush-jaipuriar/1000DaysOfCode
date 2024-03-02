package JavaTheory;

interface Animal {
    void sound();
}

class Dog implements Animal {
    public void sound() {
        System.out.println("Woof Woof!");
    }
}

class Parent {
    void display() {
        System.out.println("Parent class method");
    }
}

class Child extends Parent {
    void display() {
        System.out.println("Child class method");
    }
}

public class MethodBinding {
    public static void main(String[] args) {
        Parent obj1 = new Parent();
        Parent obj2 = new Child();
        
        obj1.display(); // Early binding - Parent class method
        obj2.display(); // Late binding - Child class method

        // Method Binding Example for abstract methods which get resolved at compile time 
        // based on the implementation provided by the implementing method
        Animal dog = new Dog();
        dog.sound();
    }
}