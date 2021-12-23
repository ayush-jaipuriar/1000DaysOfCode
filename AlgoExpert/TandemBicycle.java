import java.util.*;

public class TandemBicycle {
	
	// Time Complexity : O(n log n)
	// Space Complexity : O(1) where n is the number of tandem bicyles
	
	public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
		Arrays.sort(redShirtSpeeds);
	    Arrays.sort(blueShirtSpeeds);
	    if (fastest) {
	    	blueShirtSpeeds = reverseSort(blueShirtSpeeds);
	    }
	    int sum = 0;
	    for (int i=0; i< redShirtSpeeds.length; i++) {
	    	int redShirtSpeed = redShirtSpeeds[i];
	    	int blueShirtSpeed = blueShirtSpeeds[i];
	    	sum += Math.max(redShirtSpeed, blueShirtSpeed);
	    }
		return sum;		
	}
	
	public static int[] reverseSort(int[] arr) {
		int n = arr.length;
		int start = 0;
		int end = n -1;
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
		return arr; 
	}

}
