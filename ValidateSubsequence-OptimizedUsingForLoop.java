import java.util.*;

class Program {
  public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
    // Write your code here.		
		int sequenceIndex = 0;
		for (int i=0; i<array.size(); i++) {
			if (sequence.size() == sequenceIndex) {
				return true;
			}
			if (array.get(i) == sequence.get(sequenceIndex)) {
				sequenceIndex++;
			}
		}		
		return (sequenceIndex == sequence.size());		
  }
}
