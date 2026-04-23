import java.util.Arrays;

public class ReverseArray {
    // TC: O(n) where n is the size of the array
    // SC: O(1)
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        int start = 0;
        int end = array.length-1;
        System.out.println(Arrays.toString(array));

        while (start < end) {
            performSwap(start, end, array);
            start++;
            end--;
        }

        // After reverse

        System.out.println(Arrays.toString(array));


    }

    static void performSwap(int start, int end, int[] array) {
        int temp = array[start];

        array[start] = array[end];
        array[end] = temp;
    }
}
