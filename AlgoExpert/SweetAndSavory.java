import java.util.*;

class Program {
    // Time Complexity : O(n log n)
    // Space Complexity : O(n); n is the length of the dishes array
    public int[] sweetAndSavory(int[] dishes, int target) {
        // Initialize lists to hold sweet and savory dishes separately
        List<Integer> sweetList = new ArrayList<>();
        List<Integer> savoryList = new ArrayList<>();

        // Iterate through the dishes array to separate sweet and savory dishes
        for (int i = 0; i < dishes.length; i++) {
            int currentElement = dishes[i];
            // Check if the dish is sweet (negative number) or savory (positive number)
            if (currentElement < 0) {
                sweetList.add(currentElement); // Add to sweet list
            } else {
                savoryList.add(currentElement); // Add to savory list
            }
        }

        // Sort the sweet dishes by their absolute values in ascending order
        Collections.sort(sweetList, Comparator.comparingInt(Math::abs));
        // Sort the savory dishes in natural order (ascending)
        Collections.sort(savoryList, Comparator.naturalOrder());

        // Initialize variables to keep track of the best difference found and the result list
        int bestDifference = Integer.MAX_VALUE;
        int[] resultList = new int[2]; // To store the pair of dishes with the smallest difference
        int sweetIndex = 0; // Index for iterating through sweet dishes
        int savoryIndex = 0; // Index for iterating through savory dishes

        // Iterate through both lists simultaneously to find pairs that sum up to the target
        while (sweetIndex < sweetList.size() && savoryIndex < savoryList.size()) {
            int currentSweetDish = sweetList.get(sweetIndex);
            int currentSavoryDish = savoryList.get(savoryIndex);
            int currentSum = currentSweetDish + currentSavoryDish;

            // Check if the current pair sums up to less than or equal to the target
            if (currentSum <= target) {
                int currentDifference = target - currentSum;
                // Update the best difference and result list if the current difference is smaller
                if (currentDifference < bestDifference) {
                    bestDifference = currentDifference;
                    resultList = new int[] { currentSweetDish, currentSavoryDish };
                }
                savoryIndex++; // Move to the next savory dish
            } else {
                sweetIndex++; // Move to the next sweet dish if the current sum exceeds the target
            }
        }

        // Return the pair of dishes with the smallest difference
        return resultList;
    }
}