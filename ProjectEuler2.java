import java.util.*;
public class Main {
    public static void main(String args[]) {
        long number1 = 1;
        long number2 = 2;
        long sum = 0;
        List<Long> fibonacci = new ArrayList<>();
        fibonacci.add(number1);
        fibonacci.add(number2);
        while (sum<=4000000) {            
            sum = number1 + number2;
            fibonacci.add(sum);
            number1 = number2;
            number2 = sum;
        }
        List<Long> evenFibonacci = new ArrayList<>();
        long evenFibonacciNumbersSum = 0;
        for (long number: fibonacci)  {
            if (number % 2 == 0) {
                evenFibonacciNumbersSum += number;
            }
        }
        System.out.println(evenFibonacciNumbersSum);
        
    }
}
