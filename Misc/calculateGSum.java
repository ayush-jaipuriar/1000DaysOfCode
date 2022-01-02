import java.io.*;
import java.util.*;
public class Main {
    static double calculateGSum(int n) {
        //Base Case
        if (n==0) {
            return 1;
        }
        //Recursive Case
        double smallerAnswer = calculateGSum(n-1);
        //Calculation
        return smallerAnswer+1.0/Math.pow(2, n);
    }
    public static void main(String args[]) {
        System.out.println(calculateGSum(3));
    }
}
