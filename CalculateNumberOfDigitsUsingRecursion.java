public class Main {
   static int calculateDigit(int n) {
       if (n==0) {
           return 0;
       }
       int smallerAns = calculateDigit(n/10);
       return smallerAns+1;
   }
    public static void main(String args[]) {
        System.out.println(calculateDigit(59872));
    }
}
