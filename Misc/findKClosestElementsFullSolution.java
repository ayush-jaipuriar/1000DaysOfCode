import java.util.*;
public class Main {
    public static void main (String args[]) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr = new int[n];
		for (int i=0;i<n; i++) {
			arr[i] =sc.nextInt();
		}
		int k=sc.nextInt();
		int x=sc.nextInt();
		int currentSum=0;
		int sum=0;
		int position=0;
		for (int i=0; i<k; i++) {
			currentSum+=Math.abs(x-arr[i]);
		}
		sum=currentSum;
		for (int i=1; i<n-k+1; i++) {
			currentSum-=Math.abs(x-arr[i-1]);
			currentSum+=Math.abs(x-arr[i+k-1]);
			if (currentSum<sum) {
				sum=currentSum;
				position=i;
			}
		}
		for (int i=0; i<k; i++) {
			System.out.print(arr[i+position]+" ");
		}


    }
}
