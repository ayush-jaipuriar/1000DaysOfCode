public class NthFibonacci {
	
	public static int getNthFib(int n) {
		// Iterative Solution, best approach
		// Time Complexity : O(n)
		// Space Complexity : O(1)
		if (n == 1) {
			return 0;
		} else if (n == 2) {
			return 1;
		}
		int fib1 = 0;
		int fib2 = 1;
		int nthFib = 0;
		for (int i = 3; i <= n; i++) {
			nthFib = fib1 + fib2;
			fib1 = fib2;
			fib2 = nthFib;
		}
		return nthFib;
	}

	public static int getNthFibRecursive(int n) {
		// Time Complexity : O(2^n)
		// Space Complexity : O(n) since we are creating n call stacks
		if (n == 1) {
			return 0;
		} else if (n == 2) {
			return 1;
		}
		return getNthFibRecursive(n - 1) + getNthFibRecursive(n - 2);
	}
	
}
