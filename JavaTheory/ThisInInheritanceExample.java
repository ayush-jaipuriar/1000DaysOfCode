package JavaTheory;

class Parent {
    void display() {
        System.out.println("Inside Parent class");
    }
}

class Child extends Parent {
    void display() {
        System.out.println("Inside Child class");
    }

    void callDisplay() {
        this.display(); // Calls Child class's display method
        super.display(); // Calls Parent class's display method
    }
}

public class ThisInInheritanceExample {
    public static void main(String[] args) {
        Parent obj = new Child();
        obj.display(); // Calls Child class's display method
    }
}
