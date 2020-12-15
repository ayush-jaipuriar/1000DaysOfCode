import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try (Scanner s = new Scanner(System.in)) {
            int x = s.nextInt();
            int y = s.nextInt();
            System.out.println(x / y);
        } catch (InputMismatchException e) { 
            System.out.println(e.getClass().getName());
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
    }
}
