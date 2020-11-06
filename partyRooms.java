import java.util.*;
public class Main {
    public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] startTime = new int[n];
		int[] endTime = new int[n];
		for (int i=0; i<n; i++) {
			startTime[i] = sc.nextInt();
			endTime[i] = sc.nextInt();
		}
		Arrays.sort(startTime);
		Arrays.sort(endTime);
		int currentCount = 0;
		int maxCount = 0;
		int i=0,j=0;
		while (i<n && j<n) {
			if (startTime[i]<endTime[j]) {
				i++;
				currentCount++;
			} else {
				j++;
				currentCount--;
			}
			maxCount = Math.max(maxCount, currentCount);
		}
		System.out.println(maxCount);

    }
}
