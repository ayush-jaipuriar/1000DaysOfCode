import java.util.*;

class Program {
  public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
    // Time Complexity is O(n) and Space Complexity is O(1)
		int arrayIndex = 0;
		int sequenceIndex = 0;
		while (arrayIndex < array.size() && sequenceIndex < sequence.size()){
			if (array.get(arrayIndex) == sequence.get(sequenceIndex)) {
				sequenceIndex++;
			}
			arrayIndex++;
		}		
    return (sequenceIndex == sequence.size());
  }
}
