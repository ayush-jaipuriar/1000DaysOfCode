import java.util.*;
public class Main {
    public static void main (String args[]) {
        Scanner sc= new Scanner(System.in);
        long n=sc.nextLong();
        int countOf5=0;
        while (n!=0) {
            countOf5+=(n/5);
            n/=5;
        }
        System.out.println(countOf5);
    }
}
