import java.util.*;
public class Main {
    public static void main (String args[]) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr= new int[n];
		for (int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int zeroIndex=0;
		for (int i=0; i<arr.length; i++) {
			if (arr[i]!=0) {
				arr[zeroIndex++] = arr[i];
			}
		}
		Arrays.fill(arr, zeroIndex, arr.length, 0);
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}

    }
}
