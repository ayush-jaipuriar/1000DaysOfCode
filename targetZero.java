import java.util.*;
public class Main {
    public static void main (String args[]) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        List<Integer> list = new ArrayList<>();
        int max = n/2;
        for (int i=1; i<=max; i++) {
            list.add(i);
            list.add(-1*i);
        }
        if (n%2==1) {
            list.add(0);
        }
        Collections.sort(list);
        for (int item:list) {
            System.out.print(item+" ");
        }
    }
}
