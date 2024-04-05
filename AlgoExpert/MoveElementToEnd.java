import java.util.List;

public class MoveElementToEnd {
    public static void main(String[] args) {

    }

    // Time Complexity : O(n)
    // Space Complexity : O(1)
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

    public static void swap(int i, int j, List<Integer> array) {
        int temp = array.get(j);
        array.set(j, array.get(i));
        array.set(i, temp);
    }

}
