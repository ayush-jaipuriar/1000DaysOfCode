import java.util.*;
public class Main {
    public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int x=0; x<t; x++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			Map<Integer, Integer> hash = new HashMap<>();
			hash.put(0,1);
			int[] prefixSumArray = new int[n];
			int sum = 0;
			for (int i=0; i<arr.length; i++) {
				sum+=arr[i];
				prefixSumArray[i] = sum;
			}
			for (int i=0; i<prefixSumArray.length; i++) {
				if (!hash.containsKey(prefixSumArray[i])) {
					hash.put(prefixSumArray[i], 1);
				} else {
					hash.put(prefixSumArray[i], hash.get(prefixSumArray[i])+1);
				}
			}
			int c = 0;
        	for(int i : hash.keySet()) {
				int z = hash.get(i);
				if (z>1) {
					  c += z*(z-1)/2;
				}
			}
			System.out.println(c);                              
		}

    }
}
