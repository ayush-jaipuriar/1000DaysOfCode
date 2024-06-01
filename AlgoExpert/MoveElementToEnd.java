import java.util.List;

public class MoveElementToEnd {
    /**
     * Main method placeholder. Intended for testing purposes.
     */
    public static void main(String[] args) {

    }

    /**
     * Moves all occurrences of a specified element to the end of a list.
     * 
     * @param array The input list containing elements.
     * @param toMove The integer value to move to the end of the list.
     * @return A list with all occurrences of {@code toMove} moved to the end.
     */
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int n = array.size();
        int start = 0;
        int end = n - 1;
        while (start < end) {
            while (start < end && array.get(end) == toMove) {
                end--;
            }
            if (array.get(start) == toMove) {
                swap(start, end, array);
            }
            start++;
        }
        return array;
    }

    /**
     * Swaps two elements in the list.
     * 
     * @param i Index of the first element to swap.
     * @param j Index of the second element to swap.
     * @param array The list in which to perform the swap.
     */
    public static void swap(int i, int j, List<Integer> array) {
        int temp = array.get(j);
        array.set(j, array.get(i));
        array.set(i, temp);
    }
}