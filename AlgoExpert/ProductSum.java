import java.util.*;

class ProductSum {
    // Tip: You can use `element instanceof ArrayList` to check whether an item
    // is an array or an integer.

    public static int productSum(List<Object> array) {
        return productSumHelper(array, 1);
    }

    public static int productSumHelper(List<Object> array, int multiplier) {
        // Initialize the sum to 0
        int sum = 0;

        // Loop through the main list
        for (Object obj : array) {
            // Checking if the element at the current iteration is a subList or just an Integer
            if (obj instanceof ArrayList) {
                // Since the current element is an ArrayList, we extract the sublist
                @SuppressWarnings("unchecked")
                ArrayList<Object> subList = (ArrayList<Object>) obj;
                // We pass the sublist with ++multiplier as its multiple and make a recursive call
                sum += productSumHelper(subList, multiplier + 1);
            } else {
                // This means the current element is just an integer
                sum += (int) obj;
            }
        }
        return sum * multiplier;
    }
}
