package JavaTheory;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
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


        // CompletableFuture Example for handling async tasks
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()-> 42);
        completableFuture.thenApply(result -> result / 2);
        completableFuture.thenAccept(System.out::println);


        // Difference between Runnable and Callable task
        Runnable runnableTask = ()-> System.out.println("Runnable task");
        Callable<Integer> callableTask = () -> {
            System.out.println("Callable Task");
            return 42;
        };
        ExecutorService executor2 = Executors.newFixedThreadPool(2);
        executor2.submit(runnableTask);
        executor2.submit(callableTask);
        executor2.shutdown();
        try {
            System.out.println("Callable value : " + callableTask.call());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        


    }

}
