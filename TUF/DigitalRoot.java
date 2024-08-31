package TUF;

// Time Complexity: O(1) for best case, O(log N) for average and worst cases
// Space Complexity: O(1) for best case, O(log N) for average and worst cases

class Solution {
    /**
     * Calculates the digital root of a number.
     * 
     * Digital root is the recursive sum of all digits until we get a single-digit number.
     * 
     * @param num The input number
     * @return The digital root of the input number
     */
    public int addDigits(int num) {
        // Base case: If the number has one digit, return it
        if (num < 10) {
            return num;
        }
        
        // Initialize variables to store the sum and current digit
        int sum = 0;
        int current = 0;
        
        // Continue until all digits are processed
        while (num != 0) {
            // Get the last digit
            current = num % 10;
            
            // Add the digit to the sum
            sum += current;
            
            // Remove the last digit from the number
            num /= 10;
        }
        
        // Recursively call the method with the sum
        return addDigits(sum);        
    }
}