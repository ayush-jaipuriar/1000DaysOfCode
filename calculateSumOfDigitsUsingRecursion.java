public class Main {
    static int calculateSumOfDigit(int n) {
        //Base Case
        if (n==0) {
            return 0;
        }
        //Recursive Case
        int smallerAnswer = calculateSumOfDigit(n/10);
        int lastDigit = n%10;
        //Calculation
        return smallerAnswer+lastDigit;
    }
    public static void main(String args[]) {
        System.out.println(calculateSumOfDigit(123));
    }
}
