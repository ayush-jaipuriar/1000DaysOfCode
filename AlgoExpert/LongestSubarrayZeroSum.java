import java.util.HashMap;

public class LongestSubarrayZeroSum {
    public static int findLongestSubarrayWithZeroSum(int[] arr) {
        HashMap<Integer, Integer> sumIndexMap = new HashMap<>();
        int currentSum = 0;
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            if (arr[i] == 0 && maxLength == 0) {
                maxLength = 1;
            }

            if (currentSum == 0) {
                maxLength = i + 1;
            }

            Integer prevIndex = sumIndexMap.get(currentSum);
            if (prevIndex != null) {
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                sumIndexMap.put(currentSum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] inputArray = { 15, -2, 2, -8, 1, 7, 10, 23 };
        int result = findLongestSubarrayWithZeroSum(inputArray);
        System.out.println("Length of the longest subarray with zero sum: " + result);
    }
}
