import java.util.*;

class Program {
    // Time Complexity : O(n)
    // Space Complexity : O(1); n is the length of the array
    public int majorityElement(int[] array) {
        int count = 0;
        int answer = 0;

        for (int i = 0; i < array.length; i++) {
            if (count == 0) {
                answer = array[i];
            }

            count = (array[i] == answer) ? count + 1 : count - 1;
        }

        return answer;
    }
}
