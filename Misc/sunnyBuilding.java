import java.util.*;
public class Main {
    public static void main (String args[]) {
		Scanner sc= new Scanner(System.in);
		int t;
		t=sc.nextInt();
		for (int x=0; x<t; x++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			int maxHeight =arr[0];
			int count=0;
			for (int i=0; i<n; i++) {
				if (arr[i]>=maxHeight) {
					count++;
					maxHeight=arr[i];
				} 
			}
			System.out.println(count);
		}

    }
}
