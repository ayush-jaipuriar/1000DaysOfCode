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
		int maxLength = 0;
		int ones = 0, zeroes = 0;
		for (int i=0; i<arr.length; i++) {
			ones=0;
			zeroes=0;
			for (int j=i; j<n; j++) {
				if (arr[j]==0) {
					zeroes++;
				} else {
					ones++;
				}
				if (zeroes==ones) {
					maxLength = Math.max(maxLength, j-i+1);
				}
			}
		}
		System.out.println(maxLength);
	}
}
