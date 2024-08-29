package TUF;

/**
 * Recursive implementation of Fibonacci sequence
 */
public class FibonacciRecursive {
    /**
     * Calculates the nth Fibonacci number recursively
     *
     * @param n the position of the Fibonacci number to calculate
     * @return the nth Fibonacci number
     */
    public int fib(int n) {
        // Time complexity: O(2^n)
        // Space complexity: O(n)

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            // Recursive Case
            return fib(n - 1) + fib(n - 2);
        }
    }

    /**
     * Main method to test the Fibonacci function
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        FibonacciRecursive fibonacci = new FibonacciRecursive();
        System.out.println("Fibonacci of 10: " + fibonacci.fib(10));
    }
}