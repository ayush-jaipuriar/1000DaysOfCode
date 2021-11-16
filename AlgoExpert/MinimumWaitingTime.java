import java.util.Arrays;

public class MinimumWaitingTime {
	
	// Time Complexity : O(n log n)
	// Space Complexity : O(1)
	
	public int minimumWaitingTime(int[] queries) {
		
		// Sort the array in place
		// For each query in queries, total time it takes to execute would be query * total times it would add up
		// Total time a particular query at queries[i] would take will be the query * num of indexes left to traverse in the array
		// That comes out to be queries[i] * queries.length - (i+1)
		
		int totalSum = 0;
		Arrays.sort(queries);
		int n = queries.length; 
		for (int i=0; i<n; i++) {
			totalSum += queries[i] * (n - (i+1));
		}
		return totalSum;
	}

}
