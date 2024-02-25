package JavaTheory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorFramework {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(() -> System.out.println("All is vanity"));
        executorService.shutdown();


        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(1);
        scheduledExecutor.schedule(() -> System.out.println("Running a task which will execute after 5 seconds"), 5, TimeUnit.SECONDS);
        scheduledExecutor.shutdown();


        // Handling Exceptions using Final
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(()-> 1/0);
        try {
            int result = future.get();
        } catch(Exception e) {
            System.out.println("Exception occurred : " + e.getCause());
        } finally {
            executor.shutdown();
        }

    }

}
