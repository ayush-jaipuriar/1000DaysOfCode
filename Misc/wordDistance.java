import java.util.*;
public class Main {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i=0; i<n;i++) {
            arr[i] = sc.next();
        }
        sc.nextLine();
        String word1 = sc.next();
        String word2= sc.next();
        int p1=-1;
        int p2=-1;
        int result = Integer.MAX_VALUE;
        for (int i=0;i<arr.length; i++) {
            if (arr[i].equals(word1)) {
                p1=i;
            }
            if (arr[i].equals(word2)) {
                p2=i;                
            }
            if (p1!=-1 && p2!=-1) {
                result = Math.min(result, Math.abs(p1-p2));
            }            
        }
        System.out.println(result);

    }
}
