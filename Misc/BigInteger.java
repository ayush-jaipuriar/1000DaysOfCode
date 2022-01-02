import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {        
        Scanner sc = new Scanner(System.in);
        BigInteger input1 = new BigInteger(sc.nextLine());
        BigInteger input2 = new BigInteger(sc.nextLine());
        BigInteger addResult = input1.add(input2);
        BigInteger productResult = input1.multiply(input2);
        System.out.println(addResult);
        System.out.println(productResult);                
    }
}
