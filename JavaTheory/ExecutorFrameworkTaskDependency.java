package JavaTheory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// This class demonstrates the use of ExecutorService for task dependency.
public class ExecutorFrameworkTaskDependency {
    public static void main(String[] args) {
        // Create a fixed thread pool with 5 threads.
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Submit a task that returns 42.
        Future<Integer> future1 = executor.submit(() -> {
            return 42; // Return the value 42.
        });

        // Submit another task that depends on the result of the first task.
        Future<Integer> future2 = executor.submit(() -> {
            return future1.get() / 2; // Divide the result of the first task by 2.
        });

        try {
            // Print the result of the second task.
            System.out.println("Future  2 value : " + future2.get());
        } catch (InterruptedException | ExecutionException e) {
            // Handle exceptions that might occur during task execution.
            e.printStackTrace();
        }
    }
}