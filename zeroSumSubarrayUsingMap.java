import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int maxLength=0;
		Map<Integer, Integer> hash = new HashMap<>();
		int count=0;
		for (int i=0; i<arr.length; i++) {
			count += (arr[i]==1)? 1:-1;
			if (count==0) {
				maxLength = Math.max(maxLength, i+1);
			}
			if (hash.containsKey(count)) {
				maxLength = Math.max(maxLength, i-hash.get(count));
			} else {
				hash.put(count,i);
			}
		}
		System.out.println(maxLength);
	}
}
