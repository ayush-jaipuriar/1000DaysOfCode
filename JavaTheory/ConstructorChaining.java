package JavaTheory;

public class ConstructorChaining {

    static class Vehicle {
        int wheels;
        Vehicle (int wheels) {
            this.wheels = wheels;
        }
    }

    static class Car extends Vehicle {
        String brand;
        
        Car (String brand, int wheels) {
            super(wheels);
            this.brand = brand;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "brand='" + brand + '\'' +
                    ", wheels=" + wheels +
                    '}';
        }
    }

    public static void main(String[] args) {
        Car car = new Car("BMW", 4);
        System.out.println(car.toString());
    }

}
