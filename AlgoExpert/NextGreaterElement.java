import java.util.*;

class Program {
  // Time Complexity : O(2n) i.e O(n)
  // Space Complexity : O(n); n is the number of elements in the array
  public int[] nextGreaterElement(int[] array) {
    List<Integer> stack = new ArrayList<>();
    int n = array.length;
    int[] resultArray = new int[n];
    Arrays.fill(resultArray, -1);

    for (int i=0; i<2*n; i++) {
      int circularIndex = i%n;

      while (stack.size() > 0 && array[stack.get(stack.size()-1)] < array[circularIndex]) {
        int top = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        resultArray[top] = array[circularIndex];
      } 

      stack.add(circularIndex);
    }

    return resultArray;
  }
}
