package JavaTheory;

// Engine class represents the engine of a car
class Engine {
    // Engine Implementation (details not shown)
}

// Wheel class represents a wheel of a car
class Wheel {
    // Wheel Implementation (details not shown)
}

// Car class represents a car and uses composition
class Car {
    private Engine engine; // Composition: Car has an Engine
    private Wheel wheel;   // Composition: Car has Wheels

    public Car() {
        this.engine = new Engine(); // Create an Engine instance
        this.wheel  = new Wheel();  // Create Wheel instances
        message(); // Display initialization message
    }

    // Display a message when Car is initialized
    public void message() {
        System.out.println("Car Class has been initialized");
    }
}

// Main class to demonstrate composition
public class Composition {
    public static void main(String[] args) {
        Car car = new Car(); // Create a Car instance
    }
}
