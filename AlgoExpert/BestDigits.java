import java.util.*;

class Program {
    // Time Complexity : O(N)
    // Space Complexity : O(N); N is the length of the input string
    public String bestDigits(String number, int numDigits) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            Character currentDigit = number.charAt(i);

            // Removing elements from top of stack while current digit is not smaller than
            // the element at the top of the stack
            while (!stack.isEmpty() && currentDigit > stack.peek() && numDigits > 0) {
                numDigits--;
                stack.pop();
            }

            // Adding the current element to the stack
            stack.add(currentDigit);
        }

        // Base Case when the digits were all in descending order in that case no digit
        // got removed from our stack due to our logic and numDigits still > 0
        // In this case, removing the last d digits of the number since they are the
        // least significant in terms of place value
        while (numDigits > 0) {
            numDigits--;
            stack.pop();
        }

        // Building out the result string from the stack
        StringBuilder resultString = new StringBuilder();
        while (!stack.isEmpty()) {
            resultString.append(stack.pop());
        }

        return resultString.reverse().toString();
    }
}
