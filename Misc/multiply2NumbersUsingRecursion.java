public class Main {
    static int multiply(int m, int n) {
        // Base Case
        if (n==0) {
            return 0;
        }
        // Recursive Case
        int smallerAnswer = multiply(m, n-1);
        //Calculation
        return smallerAnswer + m;
    }
    
    public static void main(String args[]) {
        System.out.println(multiply(9,5));
    }
}
