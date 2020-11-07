import java.util.*;
public class Main {
    public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] gas = new int[n];
		int[] cost = new int[n];
		for (int i=0; i<n; i++) {
			gas[i] = sc.nextInt();
		}
		for (int i=0; i<n; i++) {
			cost[i] = sc.nextInt();
		}
		int net = 0, netCost =0;
		int start = 0;
		for (int i=0; i<gas.length; i++) {
			net += gas[i] - cost[i];
			netCost += gas[i] - cost[i];
			if (netCost<0) {
				netCost=0;
				start = i+1;
			}
		}
		if (net<0) {
			System.out.println(-1);
		} else {
			System.out.println(start);
		}

    }
}
