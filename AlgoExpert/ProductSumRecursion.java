
import java.util.ArrayList;
import java.util.List;

public class ProductSumRecursion {

    /**
     * Calculates the product sum of elements in a nested list recursively.
     *
     * @param array The input list containing integers and possibly other lists.
     * @return The product sum of all elements in the list.
     */
    public static int productSum(List<Object> array) {
        // Write your code here.
        return productSumHelper(array, 1);
    }

    /**
     * Helper method to calculate the product sum recursively.
     *
     * @param array The list to process.
     * @param multiplier The current multiplier applied to sums of sublists.
     * @return The product sum of elements in the list.
     */
    public static int productSumHelper(List<Object> array, int multiplier) {
        int sum = 0;
        for (Object obj : array) {
            if (obj instanceof ArrayList) {
                @SuppressWarnings("unchecked")
                ArrayList<Object> ls = (ArrayList<Object>) obj;
                sum += productSumHelper(ls, multiplier + 1);
            } else {
                sum += (int) obj;
            }
        }
        return sum * multiplier;
    }
}