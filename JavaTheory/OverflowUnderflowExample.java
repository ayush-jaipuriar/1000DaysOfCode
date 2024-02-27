package JavaTheory;

public class OverflowUnderflowExample {
    public static void main(String[] args) {
        int maxValue = Integer.MAX_VALUE; // 2147483647
        int minValue = Integer.MIN_VALUE; // -2147483648

        // Overflow: Adding 1 to the maximum value
        int overflowResult = maxValue + 1;
        System.out.println("Overflow result: " + overflowResult); // -2147483648

        // Underflow: Subtracting 1 from the minimum value
        int underflowResult = minValue - 1;
        System.out.println("Underflow result: " + underflowResult); // 2147483647
    }
}