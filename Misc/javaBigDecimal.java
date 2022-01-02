import java.math.BigDecimal;
import java.util.*;
class Solution{

    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
      	sc.close();

        //Write your code here  
        Arrays.sort(s, Collections.reverseOrder(new Comparator<String>() {
            @Override
            public int compare (String string1, String string2) {
                if (string1 == null || string2 == null) {
                    return 0;
                }
                BigDecimal bd1 = new BigDecimal(string1);
                BigDecimal bd2 = new BigDecimal(string2);
                return bd1.compareTo(bd2);
            }
        }));

        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }

}
