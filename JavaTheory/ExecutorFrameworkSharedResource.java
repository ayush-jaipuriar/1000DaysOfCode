package JavaTheory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorFrameworkSharedResource {
    private static int counter = 0;
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // No synchronization hence led to this output
        // Current value of counter : 2
        // Current value of counter : 2
        // Current value of counter : 2
        // Current value of counter : 2
        // Current value of counter : 2
        // Current value of counter : 3
        // Current value of counter : 4
        // Current value of counter : 5
        // Current value of counter : 6
        // Current value of counter : 7
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                counter++;
                System.out.println("Current value of counter wihout synchronization : " + counter);
            });
        }
        
        // Applying Synchronization

        // Current value of counter with synchronization : 10
        // Current value of counter with synchronization : 11
        // Current value of counter with synchronization : 12
        // Current value of counter with synchronization : 13
        // Current value of counter with synchronization : 14
        // Current value of counter with synchronization : 15
        // Current value of counter with synchronization : 16
        // Current value of counter with synchronization : 17
        // Current value of counter with synchronization : 18
        // Current value of counter with synchronization : 19
        for (int i=0; i<10; i++) {
            executor.submit(() -> {
                synchronized(ExecutorFrameworkSharedResource.class) {
                    counter++;
                    System.out.println("Current value of counter with synchronization : " + counter);
                }
            });
        }
        executor.shutdown();
    }

}
