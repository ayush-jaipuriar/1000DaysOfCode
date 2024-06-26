public class NthFibonacci {

    // Method to find the nth Fibonacci number iteratively
    public static int getNthFib(int n) {
        // Base cases
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        }
        
        // Initialize first two Fibonacci numbers
        int fib1 = 0;
        int fib2 = 1;
        
        // Variable to store the nth Fibonacci number
        int nthFib = 0;
        
        // Loop through the rest of the sequence
        for (int i = 3; i <= n; i++) {
            // Calculate the next Fibonacci number
            nthFib = fib1 + fib2;
            
            // Update values for the next iteration
            fib1 = fib2;
            fib2 = nthFib;
        }
        
        // Return the nth Fibonacci number
        return nthFib;
    }

    // Recursive method to find the nth Fibonacci number
    public static int getNthFibRecursive(int n) {
        // Base cases
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        }
        
        // Recursive calculation
        return getNthFibRecursive(n - 1) + getNthFibRecursive(n - 2);
    }

}