import java.util.*;
public class Main {
    public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		Set<Integer> uniqueNumbers = new HashSet<>();
		int n= sc.nextInt();
		boolean result = false;
		while (true) {
			int num=n;
			int sum=0;
			while (num!=0) {
				sum+=(num%10)*(num%10);
				num/=10;
			}
			if (sum==1) {
				result=true;
				break;
			} 
			if (!uniqueNumbers.contains(sum)) {
				uniqueNumbers.add(sum);
			} else {
				result=false;
				break;
			}
			n=sum;
		}
	
		System.out.println(result);
    }
}
