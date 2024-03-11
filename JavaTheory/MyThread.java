package JavaTheory; // Package declaration

// Class MyThread extends the Thread class, allowing it to be used as a thread
class MyThread extends Thread {
    
    // Override the run method from the Thread class
    // This method contains the code that will be executed when the thread is started
    @Override
    public void run() {
        // Loop 10000 times
        for (int i = 0; i < 10000; i++) {
            // Print the thread ID and the current iteration count
            // Note: Using System.out.println is generally discouraged in production code due to its synchronization overhead. Consider using a logger.
            System.out.println("Thread id : " + Thread.currentThread().getId() + " count = " + i);
            
            try {
                // Introduce a short delay to simulate work being done
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // Handle the InterruptedException
                // Note: It's recommended to either re-interrupt the thread or rethrow the exception
                e.printStackTrace();
            }
        }
    }
    
    // Main method to start the execution of the program
    public static void main(String[] args) {
        // Create an instance of MyThread
        MyThread myThread = new MyThread();
        
        // Start the thread
        myThread.start();
    }
}