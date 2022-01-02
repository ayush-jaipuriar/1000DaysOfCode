import java.util.*;
public class Main {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int peak=arr[0];
        int valley=arr[0];
        int answer = 0;
        int i=0;
        while (i<arr.length-1) {
            while (i<arr.length-1 && arr[i]>=arr[i+1]) {
                i++;
            }
            valley=arr[i];
            while (i<arr.length-1 && arr[i]<=arr[i+1]) {
                i++;
            }
            peak=arr[i];
            answer+= (peak-valley);
        }
        System.out.println(answer);

    }
}
