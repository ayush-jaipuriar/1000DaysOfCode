package JavaTheory;

class Parent {
    Parent get() {
        return this;
    }

    void message() {
        System.out.println("Inside Parent");
    }
}

class Child extends Parent {
    @Override
    Child get() { // Return type changed to Child
        return this;
    }

    @Override
    void message() {
        System.out.println("Inside Child");
    }
}

class Main {
    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.get().message(); // Prints "Inside Parent"

        // Child child = new Child();
        // child.get().message(); // Prints "Inside Child"
    }
}
