public class Main {
    static int factorial(int n) {
        //Base Cases
        if (n<0) {
            return -1;
        }
        if (n==0) {
            return 1;
        }
        //Recursive Case or Assumption
        int smallerOutput = factorial(n-1);
        //Calculation
        return n*smallerOutput;
    }
    public static void main(String args[]) {
        System.out.println(factorial(-1));
    }
}
