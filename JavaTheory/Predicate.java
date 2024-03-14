package JavaTheory;

// Importing necessary classes and interfaces
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate; // Importing Predicate interface from java.util.function

// Enum to categorize products
enum Category {
    ELECTRONICS, CLOTHING, APPLIANCES;
}

// Record to represent a product with name, price, and category
record Product(String name, Integer price, Category category) {};

// Main class to demonstrate the use of Predicate with records
class PredicateExample {
    public static void main(String[] args) {
        // Creating a list of products
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 1200, Category.ELECTRONICS));
        products.add(new Product("Smartphone", 600, Category.ELECTRONICS));
        products.add(new Product("T-shirt", 35, Category.CLOTHING));
        products.add(new Product("Headphones", 80, Category.ELECTRONICS));
        products.add(new Product("Blender", 50, Category.APPLIANCES));

        // Defining a Predicate to filter expensive products
        Predicate<Product> expensive = p -> p.price() > 100; // Predicate to check if a product is expensive

        // Using the Predicate to filter and print expensive products
        products.stream().filter(expensive).forEach(System.out::println);
    }
}