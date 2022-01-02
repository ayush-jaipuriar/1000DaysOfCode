public class Main {
   static int calculateZeroes(int n) {
       //Base Case
       if (n==0) {
           return 0;
       }
       //Recursive Case
       int smallerAnswer = calculateZeroes(n/10);
       //Calculation
       int isLastDigitZero = (n%10==0)? 1:0;
       return smallerAnswer+isLastDigitZero;

   }
    public static void main(String args[]) {
        System.out.println(calculateZeroes(122));
    }
}
